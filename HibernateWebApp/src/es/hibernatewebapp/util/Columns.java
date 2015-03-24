package es.hibernatewebapp.util;

public class Columns {
	
	public enum Student{
		ID("id"),
		NAME("name"),
		SURNAME("surname"),
		BIRTHDATE("birthDate");
		String colName;
		Student(String colName){
			this.colName = colName;
		}
		
		public String colName() {
			return colName;
		}
	};
	
	public enum Exam{
		ID("idExam"),
		NAME("name"),
		DESCRIPTION("description"),
		DATE("date");
		String colName;
		Exam(String colName){
			this.colName = colName;
		}
		public String colName() {
			return colName;
		}
	};
	
	public enum Course{
		ID("id"),
		NAME("name"),
		DESCRIPTION("description"),
		START_DATE("startDate"),
		END_DATE("endDate")
		;
		String colName;
		Course(String colName){
			this.colName = colName;
		}
		public String colName() {
			return colName;
		}
	};
}
