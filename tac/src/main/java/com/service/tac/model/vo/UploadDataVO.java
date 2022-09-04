package com.service.tac.model.vo;

import org.springframework.web.multipart.MultipartFile;

public class UploadDataVO {

	private String cardname;
	private String carddesc;
	private String maxsale; 	
	// uploadFile이름으로 지정해야지만 업로드파일을 담을 수 있는 파일을 담을 수 있다.
	private MultipartFile cardImg;

	public UploadDataVO() {};
	public UploadDataVO(String cardname, String carddesc, String maxsale, MultipartFile uploadFile) {
		super();
		this.cardname = cardname;
		this.carddesc = carddesc;
		this.maxsale = maxsale;
		this.cardImg = uploadFile;
	}

	public String getCardname() {
		return cardname;
	}

	public void setCardname(String cardname) {
		this.cardname = cardname;
	}

	public String getCarddesc() {
		return carddesc;
	}

	public void setCarddesc(String carddesc) {
		this.carddesc = carddesc;
	}

	public String getMaxsale() {
		return maxsale;
	}

	public void setMaxsale(String maxsale) {
		this.maxsale = maxsale;
	}

	public MultipartFile getUploadFile() {
		return cardImg;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.cardImg = uploadFile;
	}

	@Override
	public String toString() {
		return "UploadDataVO [cardname=" + cardname + ", carddesc=" + carddesc + ", maxsale=" + maxsale
				+ ", uploadFile=" + cardImg + "]";
	}

}
