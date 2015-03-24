package com.rnr.example.webservice;

import javax.xml.ws.Endpoint;

public class CalculatorWSPublisher {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8081/WS/Calculator", new CalculatorImpl());
	}
}
