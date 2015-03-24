package es.hibernatewebapp.manager;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;

import es.hibernatewebapp.dao.ExamDAO;
import es.hibernatewebapp.dao.ExamDAOImpl;
import es.hibernatewebapp.entities.Course;
import es.hibernatewebapp.entities.Exam;
import es.hibernatewebapp.util.HibernateUtil;
import es.hibernatewebapp.util.ParameterFilter;

public class ExamManagerImpl implements ExamManager{
	
	private ExamDAO eDAO = new ExamDAOImpl();
	
	@Override
	public void addExam(Course course, String name, String description,
			Date date) {
		addExam(new Exam(course, name, description, date));
	}

	@Override
	public void addExam(Exam exam) {
		try {
			HibernateUtil.beginTransaction();
			eDAO.save(exam);
			HibernateUtil.commitTransaction();
		} catch (HibernateException e) {
			HibernateUtil.rollbackTransaction();
			System.err.println(e.getMessage());
		}
	}
	
	@Override
	public List<Exam> findExamsBy(List<ParameterFilter> parameters) {
		List<Exam> exams = null;
		try {
			HibernateUtil.beginTransaction();
			exams =  eDAO.findExamsBy(parameters);
			HibernateUtil.commitTransaction();
		} catch (HibernateException e) {
			HibernateUtil.rollbackTransaction();
			System.err.println(e.getMessage());
		}
		return exams;
	}
	@Override
	public Exam findExamById(Long id) {
		Exam exam = null;
		try {
			HibernateUtil.beginTransaction();
			exam = eDAO.findById(Exam.class, id);
			HibernateUtil.commitTransaction();
		} catch (Exception e) {
			HibernateUtil.rollbackTransaction();
			System.err.println(e);
		}
		return exam;
	}
}

