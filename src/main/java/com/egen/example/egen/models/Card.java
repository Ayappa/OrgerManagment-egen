package com.egen.example.egen.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "card")
public class Card {
	
	@Id
	@GeneratedValue
	private Long cardId;
	 
	private String cardType;
	private Integer cardNo;
	private Integer amount;
	   
	public Card() {
		super();
	}

	public Long getCardId() {
		return cardId;
	}

	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public Integer getCardNo() {
		return cardNo;
	}

	public void setCardNo(Integer cardNo) {
		this.cardNo = cardNo;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Card [cardId=" + cardId + ", cardType=" + cardType + ", cardNo=" + cardNo + ", amount=" + amount + "]";
	}

	public Card(Long cardId, String cardType, Integer cardNo, Integer amount) {
		super();
		this.cardId = cardId;
		this.cardType = cardType;
		this.cardNo = cardNo;
		this.amount = amount;
	}

	
}