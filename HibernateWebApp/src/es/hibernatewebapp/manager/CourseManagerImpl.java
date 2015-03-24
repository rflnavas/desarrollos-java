package es.hibernatewebapp.manager;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;

import es.hibernatewebapp.dao.CourseDAO;
import es.hibernatewebapp.dao.CourseDAOImpl;
import es.hibernatewebapp.dao.GenericDAOImpl;
import es.hibernatewebapp.entities.Course;
import es.hibernatewebapp.util.HibernateUtil;
import es.hibernatewebapp.util.ParameterFilter;

public class CourseManagerImpl extends GenericDAOImpl<Course, Long> implements CourseManager{

	private CourseDAO cDAO = new CourseDAOImpl();
	
	@Override
	public void addCourse(String name, String description, Date startDate,
			Date endDate) {
		Course c = new Course(name, description, startDate, endDate);
		addCourse(c);
	}
	
	@Override
	public void addCourse(Course c) {
		try {
			HibernateUtil.beginTransaction();
			cDAO.save(c);
			HibernateUtil.commitTransaction();
		} catch (Exception e) {
			HibernateUtil.rollbackTransaction();
			System.err.println(e);
		}
	}

	@Override
	public List<Course> findCoursesBy(List<ParameterFilter> parameters) {
		return super.findBy(Course.class, parameters);
	}
	
	public Course findCourseByID(Long id){
		Course c = null;
		try {
			HibernateUtil.beginTransaction();
			c = cDAO.findById(Course.class, id);
			HibernateUtil.commitTransaction();
		} catch (Exception e) {
			HibernateUtil.rollbackTransaction();
			System.err.println(e);
		}
		return c;
	}

	@Override
	public Course findOneByName(String name) {
		Course c = null;
		try {
			HibernateUtil.beginTransaction();
			c = cDAO.findOneByName(name);
			HibernateUtil.commitTransaction();
		} catch (HibernateException e) {
			System.err.println(e);
			HibernateUtil.rollbackTransaction();
		}
		return c;
	}

}
