package com.mongoapp.converters;

import com.mongodb.DBObject;

public interface Converter<T> {
	
	public DBObject toDBObject(T bean);
	public T convert (DBObject doc);
	
}
