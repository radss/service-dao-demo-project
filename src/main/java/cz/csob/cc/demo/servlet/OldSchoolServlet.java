package cz.csob.cc.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import cz.csob.cc.demo.businessobject.Person;
import cz.csob.cc.demo.service.SomeService;

/*
 * Ve web.xml namapovano na URL /old
 * Bylo by mozne pouzit i anotaci
 */
public class OldSchoolServlet extends HttpServlet {

	@Autowired
	private SomeService someService;

	private static final Logger log = LoggerFactory.getLogger(OldSchoolServlet.class);

	/*
	 * Nasledujicim fuj fuj prepsanim init() a pouzitim SpringBeanAutowiringSupport.processInjectionBasedOnServletContext
	 * docilite ze servlet je soucasti spring contextu -> ale je to fuj, urcene pro jednoduche demo, v praxi NEPOUZIVAT (viz Spring MVC aj.)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp); // kdyz chceme aby byla stejna reakce na POST i GET
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String surname = req.getParameter("surname");
		log.info("parametr surname:" + surname);
		if (surname == null || surname.isEmpty()) {
			throw new IllegalArgumentException("Vyplnte parametr surname!");
		}

		PrintWriter out = resp.getWriter();
		out.println("<html><body>");

		List<Person> persons = someService.getPersonsBySurname(surname);
		for (Person person : persons) {
			out.println(person.getName() + " " + person.getSurname() + " (" + person.getPersonalId() + ")" + "<br/>");
		}
		out.println("</body></html>");

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
	}

}
