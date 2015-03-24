package es.hibernatewebapp.entities;

public class ExamCourseId {
	
	private long idExam;
	private long idCourse;
	public long getIdExam() {
		return idExam;
	}
	public void setIdExam(long idExam) {
		this.idExam = idExam;
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
		result = prime * result + (int) (idExam ^ (idExam >>> 32));
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
		ExamCourseId other = (ExamCourseId) obj;
		if (idCourse != other.idCourse)
			return false;
		if (idExam != other.idExam)
			return false;
		return true;
	}
}
