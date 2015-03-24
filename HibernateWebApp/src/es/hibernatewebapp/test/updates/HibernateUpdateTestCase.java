package es.hibernatewebapp.test.updates;


import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import es.hibernatewebapp.entities.Mark;
import es.hibernatewebapp.entities.Student;
import es.hibernatewebapp.manager.CourseManager;
import es.hibernatewebapp.manager.CourseManagerImpl;
import es.hibernatewebapp.manager.ExamManager;
import es.hibernatewebapp.manager.ExamManagerImpl;
import es.hibernatewebapp.manager.MarkManager;
import es.hibernatewebapp.manager.MarkManagerImpl;
import es.hibernatewebapp.manager.StudentManager;
import es.hibernatewebapp.manager.StudentManagerImpl;
import es.hibernatewebapp.util.HibernateUtil;

public class HibernateUpdateTestCase {
	
	ExamManager eMan;
	CourseManager cMan;
	StudentManager sMan;
	MarkManager mMan;
	
	@Before
	public void generateInstances(){
		eMan = new ExamManagerImpl();
		cMan = new CourseManagerImpl();
		sMan = new StudentManagerImpl();
		mMan = new MarkManagerImpl();
	}
	
	@Test
	//FAILED
	//(expected =NonUniqueResultException.class )
	public void changeStudentName(){
		Student s = sMan.findStudentById(1L);
		s.setName("Matthieu 2");
		sMan.updateStudent(s);
		
		Hibernate.initialize(s.getMarks());
		
		System.out.println(s.getMarks());
	}
	
	@After
	public void shutdown(){
		HibernateUtil.shutdown();
	}
	
}
