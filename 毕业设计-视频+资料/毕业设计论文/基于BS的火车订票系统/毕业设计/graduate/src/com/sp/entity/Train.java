package com.sp.entity;
/**
 * 列车类。存储列车信息
 * 
 *
 */
public class Train {
	private String train_num; //车次
	private String station; //所有车站
	private String a_time ; //到站时间
	private String g_time;  //发车时间
	private String price;  //票价
	private int amount;  //额定载客量
	private int remainder;  //余票量
	
	public String getTrain_num() {
		return train_num;
	}
	public void setTrain_num(String trainNum) {
		train_num = trainNum;
	}
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public String getA_time() {
		return a_time;
	}
	public void setA_time(String aTime) {
		a_time = aTime;
	}
	public String getG_time() {
		return g_time;
	}
	public void setG_time(String gTime) {
		g_time = gTime;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getRemainder() {
		return remainder;
	}
	public void setRemainder(int remainder) {
		this.remainder = remainder;
	}
}
