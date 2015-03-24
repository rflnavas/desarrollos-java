package com.mongoapp.converters;

import java.util.Date;

import org.bson.types.ObjectId;

import com.mongoapp.beans.Member;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

public class MemberConverter implements Converter<Member>{
	
	
	public static MemberConverter mConverter;
	
	private MemberConverter(){
		
	}
	
	public static synchronized MemberConverter getInstance(){
		if(mConverter == null){
			mConverter = new MemberConverter();
		}
		return mConverter;
	}
	
	@Override
	public DBObject toDBObject(Member member) {
		BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
				.append(Member.NAME, member.getName())
				.append(Member.CATEGORY, member.getCategory())
				.append(Member.JOIN_DATE, member.getJoinDate());
		if(member.getId() != null){
			builder = builder.append("_id", new ObjectId(member.getId()));
		}
		return builder.get();
	}

	@Override
	public Member convert(DBObject doc) {
		Member m = new Member();
		m.setName((String)doc.get(Member.NAME));
		m.setName((String)doc.get(Member.CATEGORY));
		m.setJoinDate((Date)doc.get(Member.CATEGORY));
		return m;
	}

}
