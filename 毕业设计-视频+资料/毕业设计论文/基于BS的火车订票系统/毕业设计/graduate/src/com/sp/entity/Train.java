package com.sp.entity;
/**
 * �г��ࡣ�洢�г���Ϣ
 * 
 *
 */
public class Train {
	private String train_num; //����
	private String station; //���г�վ
	private String a_time ; //��վʱ��
	private String g_time;  //����ʱ��
	private String price;  //Ʊ��
	private int amount;  //��ؿ���
	private int remainder;  //��Ʊ��
	
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
