package com.internousdev.action.sample;
import com.opensymphony.xwork2.ActionSupport;

public class CheckAction extends ActionSupport {


    // 入力フィールドに対応したメンバ変数
    private String name;
    private String email;
    private int age;

    public String execute() throws Exception {
        return SUCCESS;
    }

    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }

    public String getEmail(){ return email; }
    public void setEmail(String email){ this.email = email; }

    public int getAge(){ return age; }
    public void setAge(int age){ this.age = age; }

}