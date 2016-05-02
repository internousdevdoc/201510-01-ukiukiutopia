package com.internousdev.ukiukiutopia.dto;

public class AdminHomeDTO {

	public int id;
	public String item;
	public int number;

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setItem(String item){
		this.item=item;
	}
	public String Item(){
		return item;
	}

	public void setNumber(int number){
		this.number=number;
	}

	public int getNumber(){
		return number;
	}

}
