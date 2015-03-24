package es.hibernatewebapp.dao;

import java.util.List;

import es.hibernatewebapp.entities.Exam;
import es.hibernatewebapp.util.ParameterFilter;


public interface ExamDAO extends GenericDAO<Exam, Long>{
	
	public static final String ALIAS = "E";
	public static final String FROM_EXAM = " from " + Exam.class.getSimpleName() + " " + ALIAS + " ";
	
	List<Exam> findExamsBy(List<ParameterFilter> parameters);
	
}
