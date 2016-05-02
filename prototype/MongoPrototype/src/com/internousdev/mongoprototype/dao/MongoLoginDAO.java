package com.internousdev.mongoprototype.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class MongoLoginDAO {

	private String admin_name;

	public String select(String id, String password) {
		
		DB db = null;
		String ret = "error";
		try {
			db = MongoDBconnector.getConnection();
			DBCollection users = db.getCollection("users");
			BasicDBObject query = new BasicDBObject("id", id)
					.append("password", password);
			DBCursor cursor = users.find(query);
			
			if (cursor.count()==1) {
				ret = "success";
				DBObject a = cursor.next();
				admin_name = (String) a.get("admin_name");		
			}
			cursor.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
}
