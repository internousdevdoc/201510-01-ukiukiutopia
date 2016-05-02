package com.internousdev.ukiukiutopia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.internous.dto.PrototypeDTO;



public class PrototypeDAO {

	Connection con;
	boolean action;


	public List<AdminHomeDTO> itemList1 = new ArrayList<AdminHomeDTO>();

//検索するメソッド
	public boolean select()throws Exception{
		System.out.println("select - メソッド実行");
		action=false;
		con = DBconnector.getConnection();

		try{
		String sql = "select * from prototype";

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


//アップデートするメソッド
	public int update(int updateid, int updatenumber)throws Exception{
		System.out.println("update - メソッド実行");
		con = DBconnector.getConnection();
		int rscount=0;
		try{
		String sql = "update prototype set number=? where id=?";

		PreparedStatement ps2;

		ps2=con.prepareStatement(sql);
		ps2.setInt(1, updatenumber);
		ps2.setInt(2, updateid);

		System.out.println("update - ps2 -"+ ps2);

		rscount = ps2.executeUpdate();

		System.out.println("update - rsCount - 実行");
		if(rscount > 0){
		System.out.println("update - rsCount - Update OK");
		}//if


	}catch(Exception e){
		e.printStackTrace();
	}finally{
		con.close();
	}//finally
		System.out.println("update - return -" + rscount);
		return rscount;
	}//update


//インサートするメソッド
	public int insert(String insertitem, int insertinumber)throws Exception{

		con = DBconnector.getConnection();

		String sql = "insert into prototype(item,number) value(?,?)";

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


//デリートするメソッド
	public int delete(int delid)throws Exception{

		con = DBconnector.getConnection();
		int rscount=0;
		try{

		String sql = "delete from prototype where id=?";

		PreparedStatement ps2;
		ps2 = con.prepareStatement(sql);
		ps2.setInt(1,delid);

		rscount = ps2.executeUpdate();

		if(rscount >0){
			System.out.println("delete - デリート成功");
		}else{
			System.out.println("delete - デリート失敗");
		}

	}catch(Exception e){
		e.printStackTrace();
	}finally{
		con.close();
	}//finally
		return rscount;
	}


	public List<AdminHomeDTO> getItemList1(){
		return itemList1;
	}

}//class

