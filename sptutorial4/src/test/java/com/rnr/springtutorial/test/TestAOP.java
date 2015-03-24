package com.rnr.springtutorial.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rnr.springtutorial.beans.Gun;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class TestAOP extends TestCase{

	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TestAOP( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TestAOP.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() throws Exception
    {
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("com/rnr/springtutorial/config/beans.xml");
    	Gun gun = (Gun)ctx.getBean("gun");
    	try {
        	gun.shoot();
        	gun.shoot(6);
        	gun.shoot("Silver bullet");
        	
		} catch (Exception e) {
			System.out.println("Caught exception " + e.getMessage());
		}
    	gun.setZoom(5);
    	gun.getZoom();
    	gun.reload();
    	((ConfigurableApplicationContext)ctx).close();
    }

}
