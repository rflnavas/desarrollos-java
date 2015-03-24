package com.mongoapp.beans;

public abstract class Bean {
	
	protected String id;
	
	public String getId(){
		return this.id;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
}
