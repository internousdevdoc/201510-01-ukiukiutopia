package com.internousdev.mongoprototype.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.mongoprototype.dao.MongoLoginDAO;
import com.opensymphony.xwork2.ActionSupport;

public class MongoLoginAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;

	private String id;
	private String password;
	private Map<String, Object> session;
	
	public String execute(){
		MongoLoginDAO dao = new MongoLoginDAO();
		String ret = dao.select(id, password);
		session.put("name_key", dao.getAdmin_name());
		return ret;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}