package com.rnr.springtutorial.servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigContextListener implements ServletContextListener{
	
	ApplicationContext ctx = null;

	public void contextInitialized(ServletContextEvent sce) {
		//String appCtx = sce.getServletContext().getInitParameter("contextConfigLocation");
		//ctx = new ClassPathXmlApplicationContext(appCtx);
		//sce.getServletContext().setAttribute("ctx", ctx);
	}

	public void contextDestroyed(ServletContextEvent sce) {
		//System.out.println("Closing resources...");
		//((ConfigurableApplicationContext)ctx).close();
	}}
