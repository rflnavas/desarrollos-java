package es.hibernatewebapp.manager;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;

import es.hibernatewebapp.dao.StudentDAO;
import es.hibernatewebapp.dao.StudentDAOImpl;
import es.hibernatewebapp.entities.Mark;
import es.hibernatewebapp.entities.Student;
import es.hibernatewebapp.util.HibernateUtil;
import es.hibernatewebapp.util.ParameterFilter;

public class StudentManagerImpl implements StudentManager{

	private StudentDAO sDAO = new StudentDAOImpl();
	
	@Override
	public List<Student> findStudentsBy(List<ParameterFilter> params) {
		List<Student> students = null;
		try {
			HibernateUtil.beginTransaction();
			students =  sDAO.findStudentsBy(params);
			HibernateUtil.commitTransaction();
		} catch (HibernateException e) {
			HibernateUtil.rollbackTransaction();
			System.err.println(e.getMessage());
		}
		return students;
	}
	
	@Override
	public void addStudent(Student s) {
		try {
			HibernateUtil.beginTransaction();
			sDAO.save(s);
			HibernateUtil.commitTransaction();
			
		} catch (HibernateException e) {
			HibernateUtil.rollbackTransaction();
			System.err.println(e.getMessage());
		}
	}
	@Override
	public void addStudent(String name, String surname, Date birthdate) {
		addStudent(new Student(name, surname, birthdate));
	}

	@Override
	public Student findStudentById(Long id) {
		Student s = null;
		try {
			HibernateUtil.beginTransaction();
			s = sDAO.findById(Student.class, id);
			HibernateUtil.commitTransaction();
		} catch (HibernateException e) {
			HibernateUtil.rollbackTransaction();
		}
		return s;
	}
	
	@Override
	public void updateStudent(Student s) {
		try {
			HibernateUtil.beginTransaction();
			sDAO.merge(s);
			HibernateUtil.commitTransaction();
			
		} catch (HibernateException e) {
			System.err.println(e);
			HibernateUtil.rollbackTransaction();
		}
	}

	@Override
	public Set<Mark> getStudentMarks(Long id) {
		Set<Mark> marks = new HashSet<>();
		try {
			HibernateUtil.beginTransaction();
			marks = sDAO.getStudentMarks(id);
			HibernateUtil.commitTransaction();
		} catch (Exception e) {
			System.err.println(e);
			HibernateUtil.rollbackTransaction();
		}
		
		return marks;
	}
	
}
