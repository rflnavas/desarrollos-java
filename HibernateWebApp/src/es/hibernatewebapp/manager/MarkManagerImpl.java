package es.hibernatewebapp.manager;

import org.hibernate.HibernateException;

import es.hibernatewebapp.dao.MarkDAO;
import es.hibernatewebapp.dao.MarkDAOImpl;
import es.hibernatewebapp.entities.Exam;
import es.hibernatewebapp.entities.Mark;
import es.hibernatewebapp.entities.Student;
import es.hibernatewebapp.util.HibernateUtil;

public class MarkManagerImpl implements MarkManager{
	
	private MarkDAO mDAO = new MarkDAOImpl();
	
	@Override
	public void addMark(Student s, Exam e, double score) {
		Mark m = new Mark(s, e, score);
		addMark(m);
	}

	@Override
	public void addMark(Mark m) {
		try {
			HibernateUtil.beginTransaction();
			mDAO.save(m);
			HibernateUtil.commitTransaction();
			
		} catch (HibernateException e) {
			HibernateUtil.rollbackTransaction();
			System.err.println(e.getMessage());
		}
	}

}
