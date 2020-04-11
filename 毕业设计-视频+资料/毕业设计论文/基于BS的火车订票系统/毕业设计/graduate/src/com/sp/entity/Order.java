package com.sp.entity;

import java.util.Date;

/**
 * ������Ϣ
 *
 *
 */
public class Order {
	private int id; //������
	private int user_id; //�û����
	private String train_num; //��κ�
	private String g_time; //����ʱ��
	private Date order_time ; //�µ�ʱ��	
	private String origin; //���վ
	private String terminus; //�յ�վ
	private String leaveTime ; //��������
	private String a_time;  //��վʱ��
	private float price; //Ʊ��
	private int remainder;	//��Ʊ
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRemainder() {
		return remainder;
	}
	public void setRemainder(int remainder) {
		this.remainder = remainder;
	}
	public int getId() {
		return id;
	}
	
	
	public String getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(String leaveTime) {
		this.leaveTime = leaveTime;
	}
	public String getA_time() {
		return a_time;
	}
	public void setA_time(String aTime) {
		a_time = aTime;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int userId) {
		user_id = userId;
	}
	public String getTrain_num() {
		return train_num;
	}
	public void setTrain_num(String trainNum) {
		train_num = trainNum;
	}
	
	public String getG_time() {
		return g_time;
	}
	public void setG_time(String gTime) {
		g_time = gTime;
	}
	public Date getOrder_time() {
		return order_time;
	}
	public void setOrder_time(Date orderTime) {
		order_time = orderTime;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getTerminus() {
		return terminus;
	}
	public void setTerminus(String terminus) {
		this.terminus = terminus;
	}
	
	
}
