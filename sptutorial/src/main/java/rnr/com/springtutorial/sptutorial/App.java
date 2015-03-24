package rnr.com.springtutorial.sptutorial;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import rnr.com.springtutorial.sptutorial.beans.Animal;
import rnr.com.springtutorial.sptutorial.beans.Jungle;


/**
 * Hello world!
 *
 */
public class App{
    public static void main( String[] args ){
    	//System.out.println("hola");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("rnr/com/springtutorial/sptutorial/beans/beans.xml");
        Animal t = (Animal)ctx.getBean("tiger");
        Animal z = (Animal)ctx.getBean("zebra");
        Jungle j = (Jungle)ctx.getBean("jungle");
        
        System.out.println(t);
        System.out.println(z);
        System.out.println(j);
        
        
        
        ((ConfigurableApplicationContext)ctx).close();
    }
}
