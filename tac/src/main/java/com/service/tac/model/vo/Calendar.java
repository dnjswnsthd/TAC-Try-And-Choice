package com.service.tac.model.vo;

public class Calendar {
	private int id;
	private String title;
	private String start;
	private String end;
	private int price;
	private boolean allday;

	public Calendar() {
		super();
	}

	public Calendar(int id, String title, String start, String end, int price, boolean allday) {
		super();
		this.id = id;
		this.title = title;
		this.start = start;
		this.end = end;
		this.price = price;
		this.allday = allday;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isAllday() {
		return allday;
	}

	public void setAllday(boolean allday) {
		this.allday = allday;
	}

	@Override
	public String toString() {
		return "Calendar [id=" + id + ", title=" + title + ", start=" + start + ", end=" + end + ", price=" + price
				+ ", allday=" + allday + "]";
	}

}
