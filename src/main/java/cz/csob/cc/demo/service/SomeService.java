package cz.csob.cc.demo.service;

import java.util.List;
import cz.csob.cc.demo.businessobject.Person;

public interface SomeService {

	public List<Person> getPersonsBySurname(String surname);

	public void saveNewPerson(Person person);

}
