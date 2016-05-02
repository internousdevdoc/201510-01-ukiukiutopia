package com.internousdev.struts2.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBmanager {

    private static String driverName = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost/prototype";
    private static String user = "root";
    private static String pass = "mysql";
    public static Connection getConnection() {
    	System.out.println("★★DBconnector内");

        Connection con = null;
        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(url,user,pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
	public void setDB(String string) {
		// TODO 自動生成されたメソッド・スタブ
		
		
	}
}