package com.rnr.example.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface Calculator {

	@WebMethod public double sqrt(double d); 
	
}
