package com.mongoapp.dao.criteria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mongodb.BasicDBObject;


public class Criteria {
	//key- String : the name of a field
	Map <String, List<FieldValueOperator>> criteria;
	
	public Criteria() {
		criteria = new HashMap<>();
	}
	
	public void add(String field, String value){
		add(field, value, null);
	}
	
	public void add(String field, Object value, String operator) {
		List<FieldValueOperator> fvoList = null;
		if(criteria.get(field) == null){
			fvoList = new ArrayList<FieldValueOperator>();
			fvoList.add(new FieldValueOperator(field, value, operator));
			criteria.put(field, fvoList);
		}else{
			fvoList = criteria.get(field);
			fvoList.add(new FieldValueOperator(field, value, operator));
		}
	}
	/*
	 ArrayList<String> vals = new ArrayList<String>();

     for (int i=0; i < prdList; i++){
         vals.add(prdList.get(i));
     }

     DBObject obj = new BasicDBObject (mongoKey, new BasicDBObject("$in", vals));
     builder.or(obj);
     
     BasicDBObject gtQuery = new BasicDBObject();
	gtQuery.put("score", new BasicDBObject("$gt", 2).append("$lt", 5));	
	gtQuery.append(key, val)
	DBCursor cursor = collection.find(gtQuery);
*/
	
	public void remove(String field) {
		criteria.remove(field);
	}
	
	public void removeFieldValueOperator(String field, String operator) {
		List<FieldValueOperator> fvoList = criteria.get(field);
		for(FieldValueOperator fvo : fvoList){
			if(fvo.getOperator().equals(operator)){
				fvoList.remove(fvo);
				break;
			}
		}
	}

	public void clear() {
		criteria.clear();
	}

	public Map<String, List<FieldValueOperator>> getCriteria() {
		return criteria;
	}

	public void setCriteria(Map<String, List<FieldValueOperator>> criteria) {
		this.criteria = criteria;
	}
	
	public BasicDBObject processCriteria(){
		
		BasicDBObject query = new BasicDBObject();
		for(Map.Entry<String, List<FieldValueOperator>> e : this.criteria.entrySet()){
			List<FieldValueOperator> fvoList = this.criteria.get(e.getKey());
			for(FieldValueOperator fvo: fvoList){
				if(fvo.getOperator() == null){
					query.append(fvo.getField(), fvo.getValue());
				}
				else{
					query.put(fvo.getField(), 
							new BasicDBObject(fvo.getOperator(), fvo.getValue()));
				}
			}
		}
		return query;
	}
}
