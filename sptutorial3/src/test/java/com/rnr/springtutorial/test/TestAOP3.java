package com.rnr.springtutorial.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rnr.springtutorial.beans.Gun;

public class TestAOP3 {
	public static void main (String[] args)
    {
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("com/rnr/sptutorial3/config/beans.xml");
    	
    	Gun gun = (Gun)ctx.getBean("gun");
    	
    	gun.shoot();
    	
    	((ConfigurableApplicationContext)ctx).close();
    }
}
