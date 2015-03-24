package es.hibernatewebapp.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.proxy.HibernateProxy;

import es.hibernatewebapp.entities.Course;
import es.hibernatewebapp.entities.Exam;
import es.hibernatewebapp.entities.Mark;
import es.hibernatewebapp.entities.Student;
import es.hibernatewebapp.manager.CourseManager;
import es.hibernatewebapp.manager.CourseManagerImpl;
import es.hibernatewebapp.manager.ExamManager;
import es.hibernatewebapp.manager.ExamManagerImpl;
import es.hibernatewebapp.manager.StudentManager;
import es.hibernatewebapp.manager.StudentManagerImpl;
import es.hibernatewebapp.util.Columns;
import es.hibernatewebapp.util.Constants;
import es.hibernatewebapp.util.HibernateUtil;
import es.hibernatewebapp.util.Operator;
import es.hibernatewebapp.util.ParameterFilter;

public class MainTest {
	public static void main(String[] args) throws Exception {
		//newExamsToCourse();
		//changeStudentName();
		getMarks();
	}
	
	public static void getMarks(){
		/*StudentManager sMan = new StudentManagerImpl();
		Student s = sMan.findStudentById(1L);
		s.setName("Matthieu 2");
		sMan.updateStudent(s);
		HibernateUtil.beginTransaction();
		Hibernate.initialize(s.getMarks());
		Iterator<Mark> itMarks = s.getMarks().iterator();
		
		while(itMarks.hasNext()){
			System.out.println(itMarks.next());
		}
		HibernateUtil.commitTransaction();*/
		Session sess = HibernateUtil.getSession();
		HibernateUtil.beginTransaction();
		Query q =sess.createQuery("select s from Student s where s.id = :id_student");
		q.setLong("id_student", 1L);
		Student s = (Student)q.setMaxResults(1).uniqueResult();
		
		//Dos formas de evitar:"failed to lazily initialize a collection"
		//1
		Hibernate.initialize(s.getMarks());//<---Siempre dentro de una transaccion!!!
		//o 2 : algo como s.getMarks().size() <-- Esto que se inicialice igualmente
		
		HibernateUtil.commitTransaction();//s.getMarks() funcionará si y sólo si va antes de terminar la transacción!!
		System.out.println(s.getMarks());
		
	}
	
	public static void changeStudentName(){
		StudentManager sMan = new StudentManagerImpl();
		Student s = sMan.findStudentById(1L);
		s.setName("Matthieu 2");
		HibernateUtil.beginTransaction();
		System.out.println( HibernateUtil.getSession().isDirty());
		HibernateUtil.commitTransaction();
		HibernateUtil.closeSession();
		Session session2 = HibernateUtil.openSession();
		
		HibernateUtil.beginTransaction();
		//sMan.updateStudent(s);
		session2.merge(s);
		HibernateUtil.commitTransaction();
		
		session2.close();
	}
	
	public static  void newExamsToCourse() throws Exception{
		
		final String S_NAME = "Maths";
		CourseManager cMan = new CourseManagerImpl();
		ExamManager eMan = new ExamManagerImpl();
//		Course c1 = cMan.findCourseByID(95L);
//		Course c2 = cMan.findCourseByID(96L);
		
		ParameterFilter pf = new ParameterFilter(Columns.Exam.NAME.colName(), Operator.EQ, S_NAME);
		List<ParameterFilter> lp = new ArrayList<>();
		lp.add(pf);
		Course crs = cMan.findOneByName(S_NAME);
		Exam e1 = new Exam(crs, "Maths Test", "Maths Test", Constants.DDMMYYY_Format.parse("24/04/2014"));
		//Exam e2 = new Exam(null, "Biology Test", "Theory Test", Constants.DDMMYYY_Format.parse("20/06/2014"));
		eMan.addExam(e1);
		//eMan.addExam(e2);
//		Assert.assertNotNull("Unable to find a course whose name is :" + S_NAME, crs);
	}
}
