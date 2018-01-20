package cz.csob.cc.demo.dao;

import java.util.List;
import cz.csob.cc.demo.businessobject.Person;

public interface AcomDao {

	List<Person> getPersonsBySurname(String surname);

}
