package es.hibernatewebapp.entities;

public class Teacher extends Person{
	
	private int idDepartment;
	
	public Teacher() {
	}

	public int getIdDepartment() {
		return idDepartment;
	}

	public void setIdDepartment(int idDepartment) {
		this.idDepartment = idDepartment;
	}
	
}
