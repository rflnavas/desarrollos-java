package es.hibernatewebapp.dao;

import java.util.List;

import es.hibernatewebapp.entities.Course;
import es.hibernatewebapp.util.ParameterFilter;

public interface CourseDAO extends GenericDAO<Course, Long>{
	
	public static final String ALIAS = "C";
	public static final String FROM_COURSE = " from " + Course.class.getSimpleName() + " " + ALIAS + " ";
	
	List<Course> findCoursesBy(List<ParameterFilter> params);
	
	Course findOneByName(String name);
}
