package com.mongoapp.listeners;

import java.net.UnknownHostException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.mongodb.MongoClient;

@WebListener
public class MongoAppContextListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		MongoClient mClient = (MongoClient) sce.getServletContext().getAttribute("MongoClient");
		mClient.close();
		System.out.println("Mongo client has been successfully closed ...");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			ServletContext sc = sce.getServletContext();
			String host = (String)sc.getInitParameter("MONGODB_HOST");
			int port = Integer.parseInt((String)sc.getInitParameter("MONGODB_PORT"));
			
			MongoClient mClient = new MongoClient(host, port);
			sc.setAttribute("MongoClient", mClient);
		} catch (UnknownHostException e) {
			throw new RuntimeException("Mongo init failed!");
		}
		
	}
	
	
}
