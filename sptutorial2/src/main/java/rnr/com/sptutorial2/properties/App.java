package rnr.com.sptutorial2.properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import rnr.com.sptutorial2.beans.Robot;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 ApplicationContext ctx = new ClassPathXmlApplicationContext("rnr/com/sptutorial2/beans/beans.xml");
    	 Robot rb = (Robot)ctx.getBean("robot");
    	 rb.speak();
    	 
    	 ((ConfigurableApplicationContext)ctx).close();
    }
}
