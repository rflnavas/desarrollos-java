package com.rnr.springtutorial.beans;

import org.springframework.stereotype.Component;

@Component("robot")
public class Robot implements Unit{
	
	public Robot() {
		System.out.println("Constructing a new robot ...");
	}
	public void speak() {
		System.out.println("Hello!");
	}
	
	public void move(){
		System.out.println("Moving...");
	}
}
