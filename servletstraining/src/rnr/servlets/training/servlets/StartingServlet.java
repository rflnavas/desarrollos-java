package rnr.servlets.training.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StartingServlet extends HttpServlet{

	private static final long serialVersionUID = 6818633449947336228L;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		ServletContext sc = getServletContext();
		Properties prop = (Properties)sc.getAttribute("appConfiguration");
		prop.getProperty("db.ip", "");
		PrintWriter pw = resp.getWriter();
		for(Object o: prop.keySet()){
			
			pw.write(prop.getProperty(o.toString()));
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException ,IOException {
		
	};
}
