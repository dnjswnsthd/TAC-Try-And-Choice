package com.service.tac.model.vo;

public class ConsumeAnalysis_ByDay {
	String day;
	int money;
	
	public ConsumeAnalysis_ByDay() {};
	public ConsumeAnalysis_ByDay(String day, int money) {
		super();
		this.day = day;
		this.money = money;
	}
	
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	@Override
	public String toString() {
		return "ConsumeAnalysis_ByDay [day=" + day + ", money=" + money + "]";
	}
	
}
