package es.hibernatewebapp.dao;

import java.util.List;

import es.hibernatewebapp.entities.Exam;
import es.hibernatewebapp.util.ParameterFilter;

public class ExamDAOImpl extends GenericDAOImpl<Exam, Long> implements ExamDAO {
	
	public ExamDAOImpl() {
	}
	
	@Override
	public List<Exam> findExamsBy(List<ParameterFilter> parameters) {
		return super.findBy(Exam.class, parameters);
	}
}
