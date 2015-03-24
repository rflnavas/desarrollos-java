package com.rnr.example.webservice;

import javax.jws.WebService;

@WebService(endpointInterface="com.rnr.example.webservice.Calculator")
public class CalculatorImpl implements Calculator{
	
	public CalculatorImpl() {
	}
	
	@Override
	public double sqrt(double d) {
		System.out.println("Executing sqrt method ...");
		return Math.sqrt(d);
	}
	
	
}
