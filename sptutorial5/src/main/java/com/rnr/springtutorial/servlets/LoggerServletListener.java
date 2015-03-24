package com.rnr.springtutorial.servlets;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LoggerServletListener implements ServletRequestListener{
	
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("LoggerContextListener destroy");
		
	}

	public void requestInitialized(ServletRequestEvent sre) {

		System.out.println("LoggerContextListener init");
		
		
		sre.getServletRequest().setAttribute("applicationContext", 1);
	}



}
