package es.hibernatewebapp.test.insertions;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.JoinColumn;

import org.hibernate.Session;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import es.hibernatewebapp.entities.Course;
import es.hibernatewebapp.entities.Exam;
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
import es.hibernatewebapp.util.Columns;
import es.hibernatewebapp.util.Constants;
import es.hibernatewebapp.util.HibernateUtil;
import es.hibernatewebapp.util.Operator;
import es.hibernatewebapp.util.ParameterFilter;

public class HibernateInsertionTestCase {
	
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
	@Ignore
	public void batch() throws Exception{
		newStudents();
		newCourses();
	}
	
	@Test
	@Ignore
	//SUCCESSFUL
	public void newExamsToAnExistingCourseWhichIsFoundById() throws ParseException{
		
		Course frenchCourse = cMan.findCourseByID(Long.valueOf(143));
		final String STR_EX = "Français exam 3";
		eMan.addExam(new Exam(frenchCourse, STR_EX, "Français exam 3", Constants.DDMMYYY_Format.parse("05/05/2014")));
		List<ParameterFilter> params = new ArrayList<>();
		params.add(new ParameterFilter(Columns.Exam.NAME.colName(), Operator.LIKE , STR_EX));
		List<Exam> frenchExams = eMan.findExamsBy(params);
		Assert.assertTrue("new French exam couldn't be found :" + STR_EX,  frenchExams.size() > 0);
	}
	
	
	@Test
	public void examResultsMaths(){
		
		Exam exam = eMan.findExamById(Long.valueOf(8));
		List<Student> lstStudents = sMan.findStudentsBy(null);
		
		if(lstStudents != null){
			for(Student s : lstStudents){
				double rScore = new BigDecimal(Math.random() * 10.0).setScale(1, RoundingMode.CEILING).doubleValue();
				mMan.addMark(s, exam, rScore);
			}
		}
	}
	
	
	@Test
	@Ignore
	//Successful
	public void newExamsToNewCourse() throws ParseException{
		
		Course crs = new Course("French", "Basic French", Constants.DDMMYYY_Format.parse("12/03/2014"), Constants.DDMMYYY_Format.parse("30/05/2014"));
		//object references an unsaved transient instance.  - save the transient instance before flushing: es.hibernatewebapp.entities.Course
		//No hemos guardado en BD la instancia "crs"
		//Esto se puede resolver de dos maneras:
		//1-Haciendo save sobre "crs"
		//2-@Cascade({CascadeType.SAVE_UPDATE})
		Exam e1 = new Exam(crs, "Français exam", "Français exam", Constants.DDMMYYY_Format.parse("24/04/2014"));
		eMan.addExam(e1);
	}
	
	@Test
	@Ignore
	//SUCCESSFUL!
	public void newExamsToAnExistingCourse() throws Exception{
		
		final String S_NAME = "Maths";
		ParameterFilter pf = new ParameterFilter(Columns.Exam.NAME.colName(), Operator.EQ, S_NAME);
		List<ParameterFilter> lp = new ArrayList<>();
		lp.add(pf);
		Course crs = cMan.findOneByName(S_NAME);
		Exam e1 = new Exam(crs, "Maths Test", "Maths Test", Constants.DDMMYYY_Format.parse("24/04/2014"));
		//Exam e2 = new Exam(null, "Biology Test", "Theory Test", Constants.DDMMYYY_Format.parse("20/06/2014"));
		eMan.addExam(e1);
		//eMan.addExam(e2);
		Assert.assertNotNull("Unable to find a course whose name is :" + S_NAME, crs);
	}
	
	@Test
	@Ignore
	public void newStudents() throws Exception{
		StudentManager sManager = new StudentManagerImpl();
		sManager.addStudent("Jean", "Muriel", Constants.DDMMYYY_Format.parse("04/11/2000"));
		sManager.addStudent("Simon", "Koll", Constants.DDMMYYY_Format.parse("16/05/1998"));
		sManager.addStudent("Erik", "Red", Constants.DDMMYYY_Format.parse("19/07/1999"));
		sManager.addStudent("Christine", "Nolovich", Constants.DDMMYYY_Format.parse("26/02/1999"));
		sManager.addStudent("Zoey", "Ginger", Constants.DDMMYYY_Format.parse("31/08/1997"));
		//HibernateUtil.shutdown();
	}
	
	@Test
	@Ignore
	public void newCourses() throws Exception{
		
		Course c1 = new Course("Maths", 
				"ALgebra and calculus", 
				Constants.DDMMYYY_Format.parse("16/09/2014"), 
				Constants.DDMMYYY_Format.parse("23/02/2014"));
		Course c2 = new Course("Biology", 
				"Animals, plants and more", 
				Constants.DDMMYYY_Format.parse("01/02/2014"), 
				Constants.DDMMYYY_Format.parse("23/06/2014"));
		
		
		cMan.addCourse(c1);
		cMan.addCourse(c2);
	}
	
	@Test
	@Ignore
	public void newStudentWithExamAndMarksDAO() throws Exception {
		
		try {
			
			Student s1 = new Student("Edward", "Hastings", Constants.DDMMYYY_Format.parse("05/09/1999"));
			
			Course c = new Course("Android Development (Intermediate)", 
					"For those who want to improve android programming skills.", 
					Constants.DDMMYYY_Format.parse("16/03/2014"), 
					Constants.DDMMYYY_Format.parse("23/06/2014"));
			Exam e1 = new Exam(c, "Android Test 1", "First Test", Constants.DDMMYYY_Format.parse("24/04/2014"));
			Exam e2 = new Exam(c, "Android Test 2", "Second Test", Constants.DDMMYYY_Format.parse("20/06/2014"));
		
			sMan.addStudent(s1);
//			cm.save(c);
//			mm.save(s1, e1, 8.66);
//			mm.save(s1, e2, 7.2);
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Test
	@Ignore
	//SUCCESSFUL!!
	public void insercionesHibernate() throws ParseException {

		Session session = HibernateUtil.getSession();

		session.beginTransaction();

//		Student s1 = new Student();
//		s1.setBirthDate(df.parse("16/03/2000"));
//		s1.setName("Joseph");
//		s1.setSurname("Wallace");
		try{
			//We first create the independent entities : Course and Student
			Course c = new Course("Android Development (Intermediate)", 
					"For those who want to improve android programming skills.", 
					Constants.DDMMYYY_Format.parse("16/03/2014"), 
					Constants.DDMMYYY_Format.parse("23/06/2014"));
			Student s1 = new Student("Edward", "Hastings", Constants.DDMMYYY_Format.parse("05/09/1999"));
			//Then the exams of the course
			Exam e1 = new Exam(c, "Android Test 1", "First Test", Constants.DDMMYYY_Format.parse("24/04/2014"));
			Exam e2 = new Exam(c, "Android Test 2", "Second Test", Constants.DDMMYYY_Format.parse("20/06/2014"));
			//And finally the marks the student got
			//Estas lineas se ejecutan bien puesto que Mark tiene el atributo exam con:
			//@JoinColumn(name = "id_exam")
			//@Cascade({CascadeType.SAVE_UPDATE})
			Mark m1 = new Mark(s1, e1, 8.66);
			Mark m2 = new Mark(s1, e2, 7.2);
			
			session.save(c);
			session.save(s1);
			session.save(m1);
			session.save(m2);
			
			session.getTransaction().commit();
		}catch(Exception e){
			System.err.println(e.getMessage());
			session.getTransaction().rollback();
		}
		/*
		Set<Mark> marks = new HashSet<>();
		marks.add(new Mark(s1, 8.5));
		marks.add(new Mark(s1, 9.0));
		marks.add(new Mark(s1, 5.25));
		for(Mark m : marks){
			s1.getMarks().add(m);
			session.save(m);
		}
		*/
		System.out.println("--->>>>>__<<<----");
	}
	
	@After
	public void shutdown(){
		HibernateUtil.shutdown();
	}

}

