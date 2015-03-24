package es.hibernatewebapp.entities;

public class StudentCourseHistory {
	
	private long idStudent;
	private long idCourse;
	
	public StudentCourseHistory() {
	}
	
	public long getIdStudent() {
		return idStudent;
	}
	public void setIdStudent(long idStudent) {
		this.idStudent = idStudent;
	}
	public long getIdCourse() {
		return idCourse;
	}
	public void setIdCourse(long idCourse) {
		this.idCourse = idCourse;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idCourse ^ (idCourse >>> 32));
		result = prime * result + (int) (idStudent ^ (idStudent >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentCourseHistory other = (StudentCourseHistory) obj;
		if (idCourse != other.idCourse)
			return false;
		if (idStudent != other.idStudent)
			return false;
		return true;
	}
	
	
}
