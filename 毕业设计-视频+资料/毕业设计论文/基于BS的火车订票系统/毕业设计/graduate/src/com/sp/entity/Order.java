package com.sp.entity;

import java.util.Date;

/**
 * 订单信息
 *
 *
 */
public class Order {
	private int id; //订单号
	private int user_id; //用户编号
	private String train_num; //班次号
	private String g_time; //发车时间
	private Date order_time ; //下单时间	
	private String origin; //起点站
	private String terminus; //终点站
	private String leaveTime ; //出发日期
	private String a_time;  //到站时间
	private float price; //票价
	private int remainder;	//余票
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
