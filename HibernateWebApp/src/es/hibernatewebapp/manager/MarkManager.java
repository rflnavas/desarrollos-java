package es.hibernatewebapp.manager;

import es.hibernatewebapp.entities.Exam;
import es.hibernatewebapp.entities.Mark;
import es.hibernatewebapp.entities.Student;

public interface MarkManager {
	
	void addMark(Student s, Exam e, double score);
	
	void addMark(Mark m);
}
