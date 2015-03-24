package com.rnr.springtutorial.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rnr.example.webservice.Calculator;
import com.rnr.example.webservice.CalculatorImplService;

public class ProcessServlet extends HttpServlet {
	
	private static final long serialVersionUID = 4819255498689457275L;
	//private static Logger log = Logger.getLogger(ProcessServlet.class);
	
	@Override
	public void init() throws ServletException {
	//	log.debug("The form is on the point of being processed");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Processing GET " + req.getAttribute("foo"));
		CalculatorImplService cis = new CalculatorImplService();
		Calculator cal = cis.getCalculatorImplPort();
		System.out.println(cal.sqrt(2)); 
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Processing POST");
	}
	
	@Override
	public void destroy() {
		System.out.println("Dying...");
	}
}
