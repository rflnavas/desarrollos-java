package com.rnr.example.client;

import com.rnr.example.webservice.Calculator;
import com.rnr.example.webservice.CalculatorImplService;

public class JAXWSClient {
	
	public static void main(String[] args) {
		CalculatorImplService cis = new CalculatorImplService();
		Calculator cal = cis.getCalculatorImplPort();
		System.out.println(cal.sqrt(2)); 
	}
}
