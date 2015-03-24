package es.hibernatewebapp.dao;

import java.util.List;
import java.util.Set;

import es.hibernatewebapp.entities.Mark;
import es.hibernatewebapp.entities.Student;
import es.hibernatewebapp.util.ParameterFilter;

public interface StudentDAO extends GenericDAO<Student, Long>{
	
	public static final String ALIAS = "S";
	public static final String FROM_STUDENT = " from " + Student.class.getSimpleName() + " " + ALIAS + " ";
	
	List<Student> findStudentsBy(List<ParameterFilter> params);
	Set<Mark> getStudentMarks(Long id);
	
}
