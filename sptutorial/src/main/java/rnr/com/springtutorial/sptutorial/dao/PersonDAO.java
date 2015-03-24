package rnr.com.springtutorial.sptutorial.dao;

import rnr.com.springtutorial.sptutorial.service.PersonService;

public class PersonDAO {
	
	private PersonService personService;
	
	public PersonDAO() {
	}

	public PersonService getPersonService() {
		return personService;
	}
	
	public void setPersonService(PersonService personService) {
		System.out.println("Setting a personService to this DAO");
		this.personService = personService;
	}
	
	
}
