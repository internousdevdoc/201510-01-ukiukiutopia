package com.internousdev.mongoprototype.action;

import com.internousdev.mongoprototype.dao.MongoPrototypeDAO;
import com.opensymphony.xwork2.ActionSupport;


public class MongoDeleteAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private int delid;
	public String action = "error";

	public String execute() throws Exception {

		System.out.println("■DeleteAction内");

		MongoPrototypeDAO dao = new MongoPrototypeDAO();
		System.out.println("■MongoPrototypeDAOに突入");
		if (dao.delete(delid))
			action = "success";
		return action;
	}

	public int getDelid() {
		return delid;
	}

	public void setDelid(int delid) {
		this.delid = delid;
	}

}
