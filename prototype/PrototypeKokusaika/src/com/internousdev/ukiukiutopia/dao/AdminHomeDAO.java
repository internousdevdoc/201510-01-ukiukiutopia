package com.internousdev.ukiukiutopia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ukiukiutopia.dto.AdminHomeDTO;
import com.internousdev.ukiukiutopia.util.DBConnector;



public class AdminHomeDAO {

	Connection con;
	boolean action;


	public List<AdminHomeDTO> itemList1 = new ArrayList<AdminHomeDTO>();

//検索するメソッド
	public boolean select()throws Exception{
		System.out.println("select - メソッド実行");
		action=false;
		con = DBConnector.getConnection();

		try{
		String sql = "select * from user";

		PreparedStatement ps2;
		ps2 = con.prepareStatement(sql);

		System.out.println("select - ps2 - "+ ps2);

		ResultSet rs = ps2.executeQuery();
		System.out.println("select - sql実行");

		while(rs.next()){
			action = true;

			AdminHomeDTO dto =new AdminHomeDTO();
			dto.setId(rs.getInt(1));
			dto.setItem(rs.getString(2));
			dto.setNumber(rs.getInt(3));

			itemList1.add(dto);
			System.out.println("select - itemList - OK");
		}//while

	}catch(Exception e){
		e.printStackTrace();
	}finally{
		con.close();
	}//finally
		System.out.println("select - return - "+ action);
		return action;

	}//select



//インサートするメソッド
	public int insert(String insertitem, int insertinumber)throws Exception{

		con = DBConnector.getConnection();

		String sql = "insert into user(item,number) value(?,?)";

		PreparedStatement ps2;
		ps2 = con.prepareStatement(sql);
		ps2.setString(1,insertitem);
		ps2.setInt(2,insertinumber);

		int rscount = ps2.executeUpdate();

		if(rscount > 0){
			System.out.println("insert - インサート完了");
		}else{
			System.out.println("insert - インサード失敗");
		}

		return rscount;
	}//insert

}//class

