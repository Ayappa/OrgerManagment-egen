package com.egen.example.egen.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.egen.example.egen.pojo.Address;

import lombok.Data;


public class Payment {
	
	private String payMentConformation;
	
//	@OneToOne
//	@JoinColumn(name="orderId")
//	private Order order;
	
	 @OneToMany(
		        cascade = CascadeType.ALL,
		        orphanRemoval = true
		    )
	private List<Card> cards;
	
	private String paymentDate;
	
	private String paymentStatus;
	
	public Payment() {
		super();
	}

	public String getPayMentConformation() {
		return payMentConformation;
	}

	public void setPayMentConformation(String payMentConformation) {
		this.payMentConformation = payMentConformation;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Override
	public String toString() {
		return "Payment [payMentConformation=" + payMentConformation + ", cards=" + cards + ", paymentDate="
				+ paymentDate + ", paymentStatus=" + paymentStatus + "]";
	}

	public Payment(String payMentConformation, List<Card> cards, String paymentDate, String paymentStatus) {
		super();
		this.payMentConformation = payMentConformation;
		this.cards = cards;
		this.paymentDate = paymentDate;
		this.paymentStatus = paymentStatus;
	}


	
}
