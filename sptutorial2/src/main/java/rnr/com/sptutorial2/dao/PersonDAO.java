package rnr.com.sptutorial2.dao;

import org.springframework.beans.factory.annotation.Autowired;

import rnr.com.sptutorial2.service.PersonService;

public class PersonDAO {
	@Autowired(required=false)
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
