package com.service.tac.model.vo;

public class Card {
	private int cardId; // card_id
	private String cardName; // card_name
	private String cardDesc; // card_desc
	private String cardImg; // card_img

	public Card() {
		super();
	}

	public Card(int cardId, String cardName, String cardDesc, String cardImg) {
		super();
		this.cardId = cardId;
		this.cardName = cardName;
		this.cardDesc = cardDesc;
		this.cardImg = cardImg;
	}

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardDesc() {
		return cardDesc;
	}

	public void setCardDesc(String cardDesc) {
		this.cardDesc = cardDesc;
	}

	public String getCardImg() {
		return cardImg;
	}

	public void setCardImg(String cardImg) {
		this.cardImg = cardImg;
	}

	@Override
	public String toString() {
		return "Card [cardId=" + cardId + ", cardName=" + cardName + ", cardDesc=" + cardDesc + ", cardImg=" + cardImg
				+ "]";
	}

}