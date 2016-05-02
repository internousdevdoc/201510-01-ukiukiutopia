package com.internousdev.mongoprototype.action;

import com.internousdev.mongoprototype.dao.MongoPrototypeDAO;
import com.opensymphony.xwork2.ActionSupport;

public class MongoUpdateAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private int updateid;
	private int updatenumber;
	public String action="error";
	
	public String execute() throws Exception{
		System.out.println("■UpdateAction内");
		MongoPrototypeDAO dao = new MongoPrototypeDAO();
		System.out.println("■PrototypeDAOに突入");
		if(dao.update(updateid, updatenumber)){
			action = "success";
		}
		
		return action;
	}
	
	public int getUpdateid(){
		return updateid;
	}
	public void setUpdateid(int updateid){
		this.updateid=updateid;
	}
	public int getUpdatenumber(){
		return updatenumber;
	}
	public void setUpdatenumber(int updatenumber){
		this.updatenumber=updatenumber;
	}
}
