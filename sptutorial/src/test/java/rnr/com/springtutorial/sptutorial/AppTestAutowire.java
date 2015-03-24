package rnr.com.springtutorial.sptutorial;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import rnr.com.springtutorial.sptutorial.dao.PersonDAO;
import rnr.com.springtutorial.sptutorial.service.PersonService;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTestAutowire 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTestAutowire( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTestAutowire.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("rnr/com/springtutorial/sptutorial/beans/beans.xml");
    	PersonDAO pDAO = (PersonDAO)ctx.getBean("personDAO");
    	PersonService pserv =  pDAO.getPersonService();
    	System.out.println(pserv);
    	
    	((ConfigurableApplicationContext)ctx).close();
    }
}
