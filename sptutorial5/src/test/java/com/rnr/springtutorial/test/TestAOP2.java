package com.rnr.springtutorial.test;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rnr.springtutorial.beans.Robot;
import com.rnr.springtutorial.beans.Unit;

public class TestAOP2 extends TestCase{
	
	public TestAOP2() {
		super("TestAOP2");
	}
	
	public void testAOP2(){
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/rnr/springtutorial/config/beans.xml");
    	Object  o = ctx.getBean("robot");
    	System.out.println(o.getClass().getName());
    	
    	System.out.println(o instanceof Unit);
    	
		Robot rb = (Robot)ctx.getBean("robot");
    	rb.speak();
    	
    	System.out.println(ctx.getBean("robot").getClass());
    	
    	((ConfigurableApplicationContext)ctx).close();
	}
}
