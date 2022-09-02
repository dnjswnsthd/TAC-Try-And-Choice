package com.service.tac.model.vo;

public class ConsumeAnalysis_Desc {
	String LCName;
	String SCName;
	int price;
	String date;
	
	public ConsumeAnalysis_Desc() {};
	public ConsumeAnalysis_Desc(String lCName, String sCName, int price, String date) {
		super();
		LCName = lCName;
		SCName = sCName;
		this.price = price;
		this.date = date;
	}
	
	public String getLCName() {
		return LCName;
	}
	public void setLCName(String lCName) {
		LCName = lCName;
	}
	public String getSCName() {
		return SCName;
	}
	public void setSCName(String sCName) {
		SCName = sCName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "ConsumeAnalysis_Desc [LCName=" + LCName + ", SCName=" + SCName + ", price=" + price + ", date=" + date
				+ "]";
	}
}
