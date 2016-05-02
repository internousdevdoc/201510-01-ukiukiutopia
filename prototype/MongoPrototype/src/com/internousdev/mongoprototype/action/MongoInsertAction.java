package com.internousdev.mongoprototype.action;

import com.internousdev.mongoprototype.dao.MongoPrototypeDAO;
import com.opensymphony.xwork2.ActionSupport;



public class MongoInsertAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private int insertid;
	private String insertitem;
	private int insertnumber;
	public String action="error";
	
	public String execute() throws Exception{
		System.out.println("■InserActiont内");
		
		MongoPrototypeDAO dao = new MongoPrototypeDAO();
		System.out.println("■PrototypeDAOに突入");

		if(dao.insert(insertid,insertitem,insertnumber))
			action="success";
		
		return action;
	}
	
	public int getInsertid(){
		return insertid;
	}
	public void setInsertid(int insertid){
		this.insertid=insertid;
	}

	public String getInsertitem(){
		return insertitem;
	}
	public void setInsertitem(String insertitem){
		this.insertitem=insertitem;
	}

	public int getInsertnumber(){
		return insertnumber;
	}
	public void setInsertnumber(int insertnumber){
		this.insertnumber=insertnumber;
	}

}
