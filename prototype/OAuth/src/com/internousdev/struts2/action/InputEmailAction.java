package com.internousdev.struts2.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.struts2.dao.InputEmailDAO;
import com.internousdev.ukiukiutopia.dao.CreateUserDAO;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.xml.internal.security.utils.Signature11ElementProxy;

public class InputEmailAction extends ActionSupport implements SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7016065614706474231L;
	private Map<String, Object> session;
	private String inputEmail;


	public String execute() throws SQLException {
		InputEmailDAO dao = new InputEmailDAO();
		String ret = dao.select(inputEmail);
		if(ret == "error"){
			  setErrorMail(getText("signUp.errorMail"));
			}
		StringBuilder userName = new StringBuilder();
		userName.append(userName1);
		userName.append(userName2);
		session.put("signUpName", userName.toString());
		session.put("signUpPassword", userPassword);
		session.put("signUpPostalCode", userPostalCode);
		StringBuilder userAddress = new StringBuilder();
		userAddress.append(userAddress1);
		userAddress.append(userAddress2);
		userAddress.append(userAddress3);
		session.put("signUpAddress", userAddress.toString());
		session.put("signUpEmail", userEmail);
		session.put("signUpTelNum", userTelNum);
		return ret;
	}

	public String getInputEmail() {
		return inputEmail;
	}

	public void setInputEmail(String inputEmail) {
		this.inputEmail = inputEmail;
	}





}