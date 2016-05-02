package com.internousdev.ukiukiutopia.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ukiukiutopia.dao.HomeDAO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String password;
	private Map<String, Object> session;

	public String execute() throws SQLException {
		HomeDAO dao = new HomeDAO();
		String ret = dao.select(id, password);
		session.put("name_key", dao.getAdmin_name());
		return ret;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
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

}
