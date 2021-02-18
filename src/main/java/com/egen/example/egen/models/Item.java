package com.egen.example.egen.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name="items")
public class Item {
	@Id
	@GeneratedValue
	private Integer itemId;
	
	@NotNull
	private String itemName;
	
	@NotNull
	private Integer itemPrice;
	
	@NotNull
	private String itemDescription;
	
	private Integer quanty;

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Integer itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public Integer getQuanty() {
		return quanty;
	}

	public void setQuanty(Integer quanty) {
		this.quanty = quanty;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", itemDescription="
				+ itemDescription + ", quanty=" + quanty + "]";
	}

	public Item(Integer itemId, @NotNull String itemName, @NotNull Integer itemPrice, @NotNull String itemDescription,
			Integer quanty) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemDescription = itemDescription;
		this.quanty = quanty;
	}

	public Item() {
		super();
	}

	
	
}
