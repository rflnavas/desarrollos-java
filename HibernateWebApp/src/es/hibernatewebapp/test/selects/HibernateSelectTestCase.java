package es.hibernatewebapp.test.selects;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
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
import es.hibernatewebapp.manager.StudentManager;
import es.hibernatewebapp.manager.StudentManagerImpl;
import es.hibernatewebapp.util.Columns;
import es.hibernatewebapp.util.Constants;
import es.hibernatewebapp.util.HibernateUtil;
import es.hibernatewebapp.util.Operator;
import es.hibernatewebapp.util.ParameterFilter;

public class HibernateSelectTestCase{
	
	@Test
	public void getStudentMarks(){
		Set<Mark> marks = sManager.getStudentMarks(1L);
		Assert.assertTrue(marks.size()>0);
	}
	
	@After
	public void shutdown(){
		HibernateUtil.shutdown();
	}
	
	@Test
	@Ignore
	public void selectStudentsWithoutAPI(){
		/*
		 * Session sess = HibernateUtil.getSession();
		Query q =sess.createQuery("select s from Student where s.id = :id_student");
		q.setLong("id_student", 1L);
		Student s = (Student)q.setMaxResults(1).uniqueResult();
		System.out.println(s);
		 */
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction t = s.beginTransaction();
		Query q = s.createQuery("from Student");
		System.out.println("-->" + q.list());
		t.commit();
		HibernateUtil.shutdown();
	}
	
	StudentManager sManager = null;
	
	@Before
	public void createStudentDAOInstance(){
		sManager = new StudentManagerImpl();
	}
	
	@Test
	@Ignore
	public void selectCourse(){
		CourseManager cMan = new CourseManagerImpl();
		Course crs = cMan.findCourseByID((long) 143);
		Assert.assertNotNull(crs);
	}
	
	@Test
	@Ignore
	public void selectExam(){
		ExamManager eMan = new ExamManagerImpl();
		Exam exam = eMan.findExamById((long) 127);
		//Exam crs = eMan.findExamsBy(parameters)((long) 127);
		Assert.assertNotNull(exam);
	}
	
	@Test
	@Ignore
	public void selectStudentManagerFindByIDusingLoad(){
		HibernateUtil.beginTransaction();
		//Ojo!! LOAD VS GET:
		//Usar load solo si estamos seguros de que existe una instancia en la BD. Ademas load podría devolver una 
		//instancia envuelta en un proxy de manera que s.getClass() != Student.class
		//Usar get : se recomienda esta alternativa. Devolverá NULL si no encuentra instancia dada la ID.
		/*
		 * Why call the load() method then? 
		 * Because since it is a proxy, it won’t hit the DB until a getter method is called.
		 */
		Student s = (Student)HibernateUtil.getSession().load(Student.class, 89L);
		Assert.assertSame(s.getClass(), Student.class);
	}
	
	@Test
	@Ignore
	public void selectStudentManagerFindByIDusingDAO(){
		long id = Long.valueOf(89);
		Student s = sManager.findStudentById(id);
		Assert.assertNotNull("Tiene que haber algún estudiante con esta id " + id, s);
		System.out.println(s);
	}
	
	
	
	@Test
	@Ignore
	public void selectStudentManagerFindBy() throws ParseException{
		
		List<ParameterFilter> listStParam = new ArrayList<>();
		listStParam.add(new ParameterFilter(
				Columns.Student.NAME.colName(), Operator.LIKE, new String[]{"Jean"}));
		Date dFrom = Constants.DDMMYYY_Format.parse("10/12/1999");
		Date dTo = Constants.DDMMYYY_Format.parse("10/11/2000");
		listStParam.add(new ParameterFilter(
				Columns.Student.BIRTHDATE.colName(), Operator.BETWEEN, new Date[]{dFrom, null}));
		List<Student> students = sManager.findStudentsBy(listStParam);

		Assert.assertTrue("Tiene que haber al menos uno",
				!students.isEmpty());
	}
	
//	@Test
//	@Ignore
//	public void selectStudentsDAOSomeOfThem(){
//		List<Student> list =  sDAO.findBy(StudentManager.StudentManagerImpl.NAME, Operator.LIKE, "Erik");
//		HibernateUtil.shutdown();
//		System.out.println(list);
//		Assert.assertTrue(list.size() > 0);
//	}
//	
	@Test
	@Ignore
	public void selectStudentsSomeOfThemUsingCriteria(){
		
		List<Student> students = new ArrayList<>();
		try {
			HibernateUtil.beginTransaction();
			Criteria criteria = HibernateUtil.getSession().createCriteria(Student.class);
			
			Date d1 = Constants.DDMMYYY_Format.parse("01/01/1998");
			Date d2 = Constants.DDMMYYY_Format.parse("01/01/2000");
			//StudentDAO.Column.BIRTHDATE.colName()
			//Cuidado con el caseSensitive. 
			//Restrictions toma el nombre de columna del bean de la clase mapeada y no de la BD
			criteria.add(Restrictions.or(
					Restrictions.between("birthDate", d1, d2),//OJO! birthDate y no birthdate!!
					Restrictions.ilike(Columns.Student.NAME.colName(), "zO%")));
			
			students = criteria.list();
			System.out.println(students);
			HibernateUtil.commitTransaction();
			Assert.assertTrue(students.size() > 0);
		} catch (Exception e) {
			HibernateUtil.rollbackTransaction();
			System.err.println(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally{
			HibernateUtil.closeSession();
			HibernateUtil.shutdown();
			
		}
	}
	
}
