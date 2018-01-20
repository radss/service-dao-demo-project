package cz.csob.cc.demo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import cz.csob.cc.dao.utils.BaseNamedParameterJdbcDaoSupport;
import cz.csob.cc.dao.utils.QueryTemplate;
import cz.csob.cc.dao.utils.QueryTemplater;
import cz.csob.cc.demo.businessobject.Person;
import cz.csob.cc.demo.dao.AcomDao;

@Component
public class AcomDaoImpl extends BaseNamedParameterJdbcDaoSupport implements AcomDao {

	@Autowired
	public AcomDaoImpl(DataSource dataSource, QueryTemplater queryTemplater) {
		super(dataSource, queryTemplater);
	}

	public List<Person> getPersonsBySurname(String surname) {
		// ziskani SQL a vyplneni parametru
		QueryTemplate template = queryTemplater.getQueryClone("getPersonsBySurnameSelect");
		template.addParam("surname", surname);

		// provedeni SQL selectu s mapovanim vyledku na list
		List<Person> persons = getNamedParameterJdbcTemplate().query(template.getSql(), template.getMap(), new RowMapper<Person>() {

			public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
				Person person = new Person();
				person.setId(rs.getInt("IdPerson"));
				person.setEmail(rs.getString("Email"));
				person.setName(rs.getString("Name"));
				person.setSurname(rs.getString("Surname"));
				person.setPersonalId(rs.getString("PersonalId"));
				person.setPersonAccount(rs.getString("PersonAccount"));
				return person;
			}
		});

		// vraceni vysledku
		return persons;
	}

}
