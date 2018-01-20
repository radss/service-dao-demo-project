package cz.csob.cc.demo.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import cz.csob.cc.demo.businessobject.Person;
import cz.csob.cc.demo.dao.AcomDao;
import cz.csob.cc.demo.service.SomeService;

@Service
public class SomeServiceImpl implements SomeService {

	@Autowired
	private AcomDao acomDao;

	private static final Logger log = LoggerFactory.getLogger(SomeServiceImpl.class);

	public List<Person> getPersonsBySurname(String surname) {
		log.info("getPersonsBySurname - surname:" + surname);

		List<Person> persons = acomDao.getPersonsBySurname(surname);

		log.info("found persons:" + persons.size());

		return persons;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public void saveNewPerson(Person person) {
		// exception => rollbackne se
	}

}
