package com.sp.entity;
/**
 * ������Ϣ
 * 
 *
 */
public class Station {
	private String start; //ʼ��վ
	private String end;   //�յ�վ
	private String g_time;//����ʱ��
	private String a_time;//��վʱ��
	private String price; // ȫ��Ʊ��
	private String train_num; //����
	private int amount;  //�Ʊ��  
	private int remainder; //��Ʊ
	
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
