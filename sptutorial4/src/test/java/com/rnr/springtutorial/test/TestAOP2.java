package com.rnr.springtutorial.test;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rnr.springtutorial.beans.Gun;
import com.rnr.springtutorial.beans.Robot;
import com.rnr.springtutorial.beans.Unit;

public class TestAOP2 extends TestCase {

	public TestAOP2() {
		super("TestAOP2");
	}

	public void testAOP2() throws Exception {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com/rnr/springtutorial/config/beans.xml");
		// Object o = ctx.getBean("robot");
		// System.out.println(o.getClass().getName());
		//
		// System.out.println(o instanceof Robot);
		//
		// Robot rb = (Robot)ctx.getBean("robot");
		// rb.speak();

		Gun gun = (Gun) ctx.getBean("gun");
		
		gun.reload();
		gun.shoot(9);
		for (int i = 0; i < 5; i++) {
			Gun.showUselessText();
			//gun.setZoom(i);
		}
		gun.setZoom(2);
		// System.out.println(ctx.getBean("robot").getClass());

		((ConfigurableApplicationContext) ctx).close();
	}
}
