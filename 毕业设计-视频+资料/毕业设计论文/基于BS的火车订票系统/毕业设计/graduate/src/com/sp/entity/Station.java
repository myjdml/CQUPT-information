package com.sp.entity;
/**
 * 车次信息
 * 
 *
 */
public class Station {
	private String start; //始发站
	private String end;   //终点站
	private String g_time;//发车时间
	private String a_time;//到站时间
	private String price; // 全程票价
	private String train_num; //车次
	private int amount;  //额定票量  
	private int remainder; //余票
	
	public String getTrain_num() {
		return train_num;
	}
	public void setTrain_num(String trainNum) {
		train_num = trainNum;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getG_time() {
		return g_time;
	}
	public void setG_time(String gTime) {
		g_time = gTime;
	}
	public String getA_time() {
		return a_time;
	}
	public void setA_time(String aTime) {
		a_time = aTime;
	}
	
	
}
