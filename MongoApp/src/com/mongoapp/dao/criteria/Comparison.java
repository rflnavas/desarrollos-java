package com.mongoapp.dao.criteria;

public enum Comparison{
	GE("$gte"),
	GT("$gt"),
	LE("$lte"),
	LT("$lt"),
	NE("$ne"),
	IN("$in"),
	NIN("$nin");
	public String type;
	Comparison(String type){
		this.type = type;
	}
}
