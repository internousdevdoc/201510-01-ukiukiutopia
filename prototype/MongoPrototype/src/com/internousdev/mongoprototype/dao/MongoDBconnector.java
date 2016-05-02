package com.internousdev.mongoprototype.dao;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MongoDBconnector {

	public static DB getConnection() {
		DB db = null;
		try {
			MongoClient client = new MongoClient("localhost", 27017);
			db = client.getDB("test");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return db;
	}
}