package com.egen.example.egen.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.egen.example.egen.pojo.Address;

import lombok.Data;

@Entity
@Data
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue
	private Integer orderId;
	
	@ManyToOne
	@JoinColumn(name="id")
	private User user;
	
	private String orderCreated;
	
	private String modifiedDate;

	
	@Embedded
	private Address shippingAddress;
	
	private String pickUp;
	
	 @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,
		        orphanRemoval = true)
	 private List<OrderedItems> items;
	
	private Integer orderSubtotal;
	private Integer orderTax;
	private Integer orderShippingCharges;
	private Integer orderTotal;
	
	private String status;
	
	@Embedded
	private Payment payment;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getOrderCreated() {
		return orderCreated;
	}

	public void setOrderCreated(String orderCreated) {
		this.orderCreated = orderCreated;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getPickUp() {
		return pickUp;
	}

	public void setPickUp(String pickUp) {
		this.pickUp = pickUp;
	}

	public List<OrderedItems> getItems() {
		return items;
	}

	public void setItems(List<OrderedItems> items) {
		this.items = items;
	}

	public Integer getOrderSubtotal() {
		return orderSubtotal;
	}

	public void setOrderSubtotal(Integer orderSubtotal) {
		this.orderSubtotal = orderSubtotal;
	}

	public Integer getOrderTax() {
		return orderTax;
	}

	public void setOrderTax(Integer orderTax) {
		this.orderTax = orderTax;
	}

	public Integer getOrderShippingCharges() {
		return orderShippingCharges;
	}

	public void setOrderShippingCharges(Integer orderShippingCharges) {
		this.orderShippingCharges = orderShippingCharges;
	}

	public Integer getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(Integer orderTotal) {
		this.orderTotal = orderTotal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", user=" + user + ", orderCreated=" + orderCreated + ", modifiedDate="
				+ modifiedDate + ", shippingAddress=" + shippingAddress + ", pickUp=" + pickUp + ", items=" + items
				+ ", orderSubtotal=" + orderSubtotal + ", orderTax=" + orderTax + ", orderShippingCharges="
				+ orderShippingCharges + ", orderTotal=" + orderTotal + ", status=" + status + ", payment=" + payment
				+ "]";
	}

	public Order(Integer orderId, User user, String orderCreated, String modifiedDate, Address shippingAddress,
			String pickUp, List<OrderedItems> items, Integer orderSubtotal, Integer orderTax,
			Integer orderShippingCharges, Integer orderTotal, String status, Payment payment) {
		super();
		this.orderId = orderId;
		this.user = user;
		this.orderCreated = orderCreated;
		this.modifiedDate = modifiedDate;
		this.shippingAddress = shippingAddress;
		this.pickUp = pickUp;
		this.items = items;
		this.orderSubtotal = orderSubtotal;
		this.orderTax = orderTax;
		this.orderShippingCharges = orderShippingCharges;
		this.orderTotal = orderTotal;
		this.status = status;
		this.payment = payment;
	}

	public Order() {
		super();
	}

	
	
}
