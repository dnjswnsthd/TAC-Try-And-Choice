package com.service.tac.model.vo;

public class ConsumeAnalysis_LargeSum {
	
	String LCname;
	int count;
	int sum;
	
	public ConsumeAnalysis_LargeSum() {};
	public ConsumeAnalysis_LargeSum(String lCname, int count, int sum) {
		super();
		LCname = lCname;
		if ( count == 1 && sum == 0) {
			this.sum = sum;
		} else {
			this.count = count;
		}
		this.sum = sum;
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
	
	@Override
	public String toString() {
		return "후후[LCname=" + LCname + ", count=" + count + ", sum=" + sum + "]";
	}
	
	

}
