package com.service.tac.model.vo;

public class ConsumeAnalysis_LargeSum {
	
	String LCname;
	int count;
	int sum;
	String Image;
	
	public ConsumeAnalysis_LargeSum() {};
	public ConsumeAnalysis_LargeSum(String lCname, int count, int sum, String image) {
		super();
		LCname = lCname;
		this.count = count;
		this.sum = sum;
		Image = image;
	}
	
	public String getLCname() {
		return LCname;
	}
	public void setLCname(String lCname) {
		LCname = lCname;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	
	@Override
	public String toString() {
		return "ConsumeAnalysis_LargeSum [LCname=" + LCname + ", count=" + count + ", sum=" + sum + ", Image=" + Image
				+ "]";
	}
	
	
	

}
