package com.mongoapp.dao;

import java.util.LinkedList;
import java.util.List;

import org.bson.types.ObjectId;

import com.mongoapp.converters.Converter;
import com.mongoapp.dao.criteria.Criteria;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public abstract class DAO<T> {
	
	public static String DATABASE_NAME = "myMongoDB";
	
	protected DB db;
	
	protected DBCollection collection;
	
	public DAO(MongoClient mClient) {
		this.db = mClient.getDB(DATABASE_NAME);
	}
	
	public List<T> read (Criteria c, Converter<T> converter){
		BasicDBObject dbObject = null;
		DBCursor dbCursor = null;
		List<T> data = new LinkedList<>();
		if(c != null){
			dbObject = c.processCriteria();
			dbCursor = this.collection.find(dbObject);
		}else{
			dbCursor = this.collection.find();
		}	
		while(dbCursor.hasNext()){
			DBObject obj = dbCursor.next();
			T mb = converter.convert(obj);
			data.add(mb);
		}
		return data;
	}
	
	public ObjectId create(T t, Converter<T> converter){
		
		DBObject obj = converter.toDBObject(t);
		this.collection.insert(obj);
		ObjectId id = (ObjectId)obj.get("_id");
		return id;
	}
	
	public abstract void update(T t);
	
	protected T get(String id, Converter<T> converter){
		DBObject query = new BasicDBObject("_id", id);
		DBObject obj = this.collection.findOne(query);
		T t = converter.convert(obj);
		return t;
	}
	
	public void remove(String id){
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", id).get();
		this.collection.remove(query);
	}
	
	
	public DBCollection getCollection() {
		return collection;
	}

	public void setCollection(DBCollection collection) {
		this.collection = collection;
	}
}
