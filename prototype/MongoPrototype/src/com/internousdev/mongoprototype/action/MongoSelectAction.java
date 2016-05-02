package com.internousdev.mongoprototype.action;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.mongoprototype.dao.MongoPrototypeDAO;
import com.internousdev.mongoprototype.dto.MongoPrototypeDTO;
import com.opensymphony.xwork2.ActionSupport;



public class MongoSelectAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	public List<MongoPrototypeDTO> itemList1 = new ArrayList<MongoPrototypeDTO>();
	public String result = "error";
	
	public String execute() throws Exception {
		
		MongoPrototypeDAO dao = new MongoPrototypeDAO();
		boolean resultDAO = dao.select();
		System.out.println("resultDAO="+resultDAO);
		System.out.println("SelectActionに復帰");
		if(resultDAO){
			itemList1.addAll(dao.getItemList1());
			result = "success";
		}
		
		return result;
	}

}
