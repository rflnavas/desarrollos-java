package com.rnr.springtutorial.beans;

public class Gun {
	
	public Gun() {
	}
	
	public void shoot() {
		System.out.println("BANG!");
	}
	
	public void shoot(int bullets){
		StringBuffer sb = new StringBuffer();
		for(int i = 0 ; i < bullets ; i++){
			sb.append("Bang! ");
		}
		System.out.println(sb.toString());
	}
	
	public void shoot(String param){
		System.out.println("param : " + param);
	}
	
}
