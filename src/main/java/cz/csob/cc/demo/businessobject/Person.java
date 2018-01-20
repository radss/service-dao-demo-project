package cz.csob.cc.demo.businessobject;

import cz.csob.cc.businessobject.BaseObject;

public class Person extends BaseObject {

	private static final long serialVersionUID = -1253980392768759684L;
	private Integer idDepartment;
	private String personalId;
	private String name;
	private String surname;
	private String email;
	private String personAccount;

/*	public Integer getIdDepartment() {
		return idDepartment;
	}
*/
/*	public void setIdDepartment(Integer idDepartment) {
		this.idDepartment = idDepartment;
	}*/

	public String getPersonalId() {
		return personalId;
	}

	public void setPersonalId(String personalId) {
		this.personalId = personalId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPersonAccount() {
		return personAccount;
	}

	public void setPersonAccount(String personAccount) {
		this.personAccount = personAccount;
	}

}
