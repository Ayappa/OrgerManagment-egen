package com.egen.example.egen.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="orderedItems")
public class OrderedItems {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderedItemsId;
	
	 @ManyToOne
	 @JoinColumn(name = "orderId")
	 private Order order;
	 
	  @ManyToOne
	  @JoinColumn(name = "itemId")
	 private Item item;
	  
	 private Integer quanty;

	public Long getOrderedItemsId() {
		return orderedItemsId;
	}

	public void setOrderedItemsId(Long orderedItemsId) {
		this.orderedItemsId = orderedItemsId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Integer getQuanty() {
		return quanty;
	}

	public void setQuanty(Integer quanty) {
		this.quanty = quanty;
	}

	public OrderedItems(Long orderedItemsId, Order order, Item item, Integer quanty) {
		super();
		this.orderedItemsId = orderedItemsId;
		this.order = order;
		this.item = item;
		this.quanty = quanty;
	}

	public OrderedItems() {
		super();
	}

	@Override
	public String toString() {
		return "OrderedItems [orderedItemsId=" + orderedItemsId + ", order=" + order + ", item=" + item + ", quanty="
				+ quanty + "]";
	}
	 
	 
}
