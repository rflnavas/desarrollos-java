package com.mongoapp.dao;

import java.util.List;

import org.bson.types.ObjectId;

import com.mongoapp.beans.Member;
import com.mongoapp.converters.MemberConverter;
import com.mongoapp.dao.criteria.Criteria;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MemberDAO extends DAO<Member> {

	private static MemberConverter memberConverter;

	static {
		memberConverter = MemberConverter.getInstance();
	}

	public MemberDAO(MongoClient mClient) {
		super(mClient);
		this.collection = db.getCollection(MongoDBCollections.MEMBERS
				.collectionName());
	}

	public Member create(Member member) {
		ObjectId objId = super.create(member, memberConverter);
		member.setId(objId.toString());
		return member;
	}

	public Member get(String id) {
		return super.get(id, memberConverter);
	}
	
	public List<Member> read(Criteria c) {
		return super.read(c, memberConverter);
	}

	//gtQuery.put("number", new BasicDBObject("$gt", 2).append("$lt", 5));
	/*
	List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
	obj.add(new BasicDBObject("number", 2));
	obj.add(new BasicDBObject("name", "mkyong-2"));
	andQuery.put("$and", obj);
	*/

	@Override
	public void update(Member member) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", member.getId()).get();
		this.collection.update(query, memberConverter.toDBObject(member));
	}

}
