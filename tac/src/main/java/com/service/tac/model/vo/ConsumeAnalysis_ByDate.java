package com.service.tac.model.vo;

public class ConsumeAnalysis_ByDate {
	String date;
	int money;
	
	public ConsumeAnalysis_ByDate() {};
	public ConsumeAnalysis_ByDate(String date, int money) {
		super();
		this.date = date;
		this.money = money;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	@Override
	public String toString() {
		return "ConsumeAnalysis_ByDate [date=" + date + ", money=" + money + "]";
	}

}
