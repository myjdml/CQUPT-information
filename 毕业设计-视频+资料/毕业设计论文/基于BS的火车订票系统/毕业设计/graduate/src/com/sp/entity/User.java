package com.sp.entity;

public class User {
	private int id;  //ID
	private String username; //用户名
	private String password; //用户密码
	private int status;  //用户权限 1、普通用户 2、管理员
	private String sex;  //用户性别
	private String phone;  //联系方式
	private String email; //电子邮箱
	private String address; //地址
	private String name; //真实姓名
	private String county; //国家
	private String papers_type; //证件类型
	private String papers_num;  //证件号码

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getPapers_type() {
		return papers_type;
	}
	public void setPapers_type(String papersType) {
		papers_type = papersType;
	}
	public String getPapers_num() {
		return papers_num;
	}
	public void setPapers_num(String papersNum) {
		papers_num = papersNum;
	}
	
	
}
