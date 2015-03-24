package com.rnr.springtutorial.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rnr.springtutorial.beans.Gun;

import junit.framework.TestCase;

public class TestAOP2 extends TestCase {
	public void testApp()
    {
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("rnr/com/sptutorial3/config/beans.xml");
    	
    	Gun gun = (Gun)ctx.getBean("gun");
    	
    	gun.shoot();
    	
    	((ConfigurableApplicationContext)ctx).close();
    }
}
