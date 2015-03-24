package com.mongoapp.dao;

public enum MongoDBCollections {
	MEMBERS("members");
	String collectionName;
	MongoDBCollections(String collectionName){
		this.collectionName = collectionName;
	}
	public String collectionName(){
		return this.collectionName;
	}
}
