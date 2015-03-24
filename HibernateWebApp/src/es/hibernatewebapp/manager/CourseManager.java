package es.hibernatewebapp.manager;

import java.util.Date;
import java.util.List;

import es.hibernatewebapp.entities.Course;
import es.hibernatewebapp.util.ParameterFilter;

public interface CourseManager {
	
	void addCourse(Course c);
	
	void addCourse(String name, String description, Date startDate, Date endDate);
	
	List<Course> findCoursesBy(List<ParameterFilter> parameters);
	
	Course findCourseByID(Long id);
	
	Course findOneByName(String name);
}
