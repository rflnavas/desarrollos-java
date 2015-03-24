package es.hibernatewebapp.dao;

import java.util.List;

import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;

import es.hibernatewebapp.entities.Course;
import es.hibernatewebapp.util.Columns;
import es.hibernatewebapp.util.HibernateUtil;
import es.hibernatewebapp.util.ParameterFilter;

public class CourseDAOImpl extends GenericDAOImpl<Course, Long> implements CourseDAO{

	public List<Course> findCoursesBy(List<ParameterFilter> parameters){
		List<Course> courses = findBy(Course.class, parameters);
		return courses;
	}

	@Override
	public Course findOneByName(String name){
		
		Course c;
		String strQuery = CourseDAO.FROM_COURSE;
		strQuery += " WHERE name = :name";
		Query query = HibernateUtil.getSession().createQuery(strQuery);
		query.setParameter(Columns.Course.NAME.colName(), name);
		try {
			c = super.findOne(query);
		} catch (NonUniqueResultException e) {
			System.err.println("NOPE!!");
			throw e;
		}
		return c;
	}
}
