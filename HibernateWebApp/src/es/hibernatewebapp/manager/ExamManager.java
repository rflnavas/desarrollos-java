package es.hibernatewebapp.manager;

import java.util.Date;
import java.util.List;

import es.hibernatewebapp.entities.Course;
import es.hibernatewebapp.entities.Exam;
import es.hibernatewebapp.util.ParameterFilter;

public interface ExamManager {
	
	void addExam(Course course, String name, String description, Date date);
	
	void addExam(Exam m);
	
	List<Exam> findExamsBy(List<ParameterFilter> parameters);
	
	Exam findExamById(Long id);
}
