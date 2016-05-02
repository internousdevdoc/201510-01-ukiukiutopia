package com.internousdev.prototypevalidation.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.prototypevalidation.util.DBConnector;

public class LoginDAO {

	private String admin_name;

	public String select(String user, String password) {

		Connection conn = null;
		String ret = "error";
		try {
			conn = (Connection) DBConnector.getConnection();
			String sql = "SELECT * FROM admin_table WHERE";
			sql += " admin_id = ? AND admin_pass = ?";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ret = "success";
				admin_name = rs.getString("admin_name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
