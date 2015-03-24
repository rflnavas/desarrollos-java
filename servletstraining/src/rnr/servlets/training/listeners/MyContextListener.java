package rnr.servlets.training.listeners;

import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyContextListener implements ServletContextListener{
	
	public enum ConfigOptions{
		DEVELOPMENT,
		PRODUCTION
	}
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		String configValue = (String) sc.getInitParameter("config");//DEVELOPMENT
		
		ConfigOptions co =ConfigOptions.valueOf(configValue);
		Properties prop = null;
		switch(co){
			case DEVELOPMENT:
				prop = loadDevelopmentConfiguration();
				break;
			case PRODUCTION:
				prop = loadProductionConfiguration();
				break;
		}
		sc.setAttribute("appConfiguration", prop);
	}

	private Properties loadDevelopmentConfiguration() {
		Properties prop = new Properties();
		prop.setProperty("db.ip", "10.1.234.21");
		prop.setProperty("db.port","1234");
		prop.setProperty("db.vendor","MySQL");
		prop.setProperty("debug", "true");
		return prop;
	}

	private Properties loadProductionConfiguration() {
		Properties prop = new Properties();
		prop.setProperty("db.ip", "10.1.234.22");
		prop.setProperty("db.port","9876");
		prop.setProperty("db.vendor","MySQL");
		prop.setProperty("debug", "false");
		return prop;
	}


}
