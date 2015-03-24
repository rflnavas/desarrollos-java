package es.hibernatewebapp.entities;

public class Department {
	
	private int idDepartment;
	private String name;
	private String description;
	
	public Department() {
	}

	public int getIdDepartment() {
		return idDepartment;
	}

	public void setIdDepartment(int idDepartment) {
		this.idDepartment = idDepartment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idDepartment;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Department? ((Department)obj).idDepartment == this.idDepartment : false;
	}
	
	
}
