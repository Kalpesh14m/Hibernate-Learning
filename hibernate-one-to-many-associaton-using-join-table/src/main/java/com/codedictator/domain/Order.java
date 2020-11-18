package com.codedictator.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ORDER_MASTER9")
public class Order implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ORDER_ID")
	private Long id;
	@Column(name="ITEM_NAME")
	private String itemName;
	private String brand;
	private Double price;

	public Order() {
		// Do Nothing
	}

	public Order(String itemName, String brand, Double price) {
		super();
		this.itemName = itemName;
		this.brand = brand;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Order ID: "+id
				+"\nItem Name: "+itemName
				+"\nBrand: "+brand
				+"\nPrice: "+price;
	}
}
