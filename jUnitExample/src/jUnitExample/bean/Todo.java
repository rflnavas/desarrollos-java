package jUnitExample.bean;

import java.util.Date;

public class Todo {
	
	private String name;
	private Date date;
	
	public Todo() {
	}
	
	public Todo(String name, Date date) {
		super();
		this.name = name;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
