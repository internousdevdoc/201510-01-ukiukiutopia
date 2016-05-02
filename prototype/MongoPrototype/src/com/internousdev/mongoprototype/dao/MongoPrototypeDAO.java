package com.internousdev.mongoprototype.dao;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.mongoprototype.dto.MongoPrototypeDTO;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

public class MongoPrototypeDAO {

	DB db;
	boolean action;

	public List<MongoPrototypeDTO> itemList1 = new ArrayList<MongoPrototypeDTO>();

	// select
	public boolean select() throws Exception {
		System.out.println("select - メソッド実行");
		action = false;
		db = MongoDBconnector.getConnection();
		DBCollection item = db.getCollection("item");
		DBCursor cursor = item.find();
		try {
			while (cursor.hasNext()) {
				action = true;
				DBObject a = cursor.next();
				MongoPrototypeDTO dto = new MongoPrototypeDTO();

				double b = (double) a.get("id");
				dto.setId((int) b);

				dto.setItem((String) a.get("item"));

				b = (double) a.get("number");
				dto.setNumber((int) b);

				itemList1.add(dto);
				System.out.println("select - itemList - OK");
			} // while

		} catch (Exception e) {
			e.printStackTrace();
			action = false;
		} finally {
			cursor.close();
		} // finally

		System.out.println("select - return - " + action);
		return action;

	}// select

	// delete
	public boolean delete(int delid) throws Exception {
		System.out.println("delete - メソッド実行");
		action = false;
		try {
			db = MongoDBconnector.getConnection();
			DBCollection item = db.getCollection("item");
			BasicDBObject query = new BasicDBObject("id", delid);
			DBCursor cursor = item.find(query);
			if (cursor.count() == 1) {
				action = true;
				item.remove(cursor.next());
			}
			cursor.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("delete - return - " + action);
		return action;
	}// delete

	// insert
	public boolean insert(int insertid, String insertitem, int insertnumber) {
		System.out.println("insert - メソッド実行");
		action = false;
		try {
			db = MongoDBconnector.getConnection();
			DBCollection item = db.getCollection("item");

			DBObject json = (DBObject) JSON.parse("{'id':" + (double) insertid + ",'item':'" + insertitem
					+ "','number':" + (double) insertnumber + "}");

			BasicDBObject query = new BasicDBObject("id", insertid);
			DBCursor cursor = item.find(query);
			if (cursor.count() == 0) {
				action = true;
				item.insert(json);
			}
			cursor.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("insert - return - " + action);
		return action;
	}// insert
	
	//update
	public boolean update(int updateid, int updatenumber)throws Exception{
		System.out.println("update - メソッド実行");
		action = false;
		try {
			db = MongoDBconnector.getConnection();
			DBCollection item = db.getCollection("item");
			BasicDBObject query = new BasicDBObject("id", updateid);
			DBCursor cursor = item.find(query);
			if (cursor.count() == 1) {
				action = true;
				DBObject a = cursor.next();
				a.put("number", (double)updatenumber);
				item.save(a);
			}
			cursor.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("update - return - " + action);
		return action;
	}//update

	public List<MongoPrototypeDTO> getItemList1() {
		return itemList1;
	}
}
