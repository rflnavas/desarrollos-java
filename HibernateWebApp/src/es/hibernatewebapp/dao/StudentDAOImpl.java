package es.hibernatewebapp.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.TypedQuery;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import es.hibernatewebapp.entities.Mark;
import es.hibernatewebapp.entities.Student;
import es.hibernatewebapp.util.HibernateUtil;
import es.hibernatewebapp.util.Operator;
import es.hibernatewebapp.util.ParameterFilter;

public class StudentDAOImpl extends GenericDAOImpl<Student, Long> implements StudentDAO{
	
	public StudentDAOImpl() {
		
	}
	
	/* The following is the same as :
		List<Student> students = null;
		Criteria criteria = HibernateUtil.getSession().createCriteria(Student.class);
		HibernateUtil.addParametersToCriteria(parameters, criteria);
		students = findMany(criteria);
	*/
	public List<Student> findStudentsBy(List<ParameterFilter> parameters){
		List<Student> students = findBy(Student.class, parameters);
		return students;
	}

	@Override
	public Set<Mark> getStudentMarks(Long id) {
		Student s = findById(Student.class, id);
		Hibernate.initialize(s.getMarks());
		return s.getMarks();
	}
	
	@SuppressWarnings("unchecked")
	public List<Student> findBy(String col, Operator op, Object o){
		try {
			HibernateUtil.beginTransaction();
			//Generar una cadena como:
			//from Student s where s.name like :name
			
			//OJO COMO SE PONE EL NOMBRE DE TABLA O DE COLUMNAS YA QUE SON CASE-SENSITIVE!!!
			StringBuilder sb = new StringBuilder(FROM_STUDENT);
			sb.append(" where ").
			append(ALIAS).append(".").append(col).
			append(op.operator()).append(":").append(col);
			
			System.out.println(sb.toString());
			Query q = HibernateUtil.getSession().createQuery(sb.toString());
			q.setParameter(col, o);
			
			//BIEN
//			Query q = HibernateUtil.getSession().createQuery("from Student s where s.name like :name");
//			q.setParameter("name", "Erik");
			
			List<Student> students = q.list();
			HibernateUtil.commitTransaction();
			return students;
		} catch (Exception e) {
			HibernateUtil.rollbackTransaction();
			throw new RuntimeException(e.getMessage());
		} finally{
			HibernateUtil.closeSession();
		}
	}

}
