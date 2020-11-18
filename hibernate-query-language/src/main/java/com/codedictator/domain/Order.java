package com.codedictator.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_MASTER11")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDER_ID")
	private Long id;
	@Column(name = "ITEM_NAME")
	private String itemName;
	@Column(name = "MODEL")
	private String model;
	@Column(name = "BRAND")
	private String brand;
	@Column(name = "PRICE")
	private Double price;
	@Column(name = "QUANTITY")
	private Integer quantity;
	
	@ManyToOne
	@JoinColumn(name="CUSTOMER_ID")
	private Customer customer;

	public Order() {
		// Do Nothing
	}

	public Order(String itemName, String model, String brand, Double price, Integer quantity) {
		super();
		this.itemName = itemName;
		this.model = model;
		this.brand = brand;
		this.price = price;
		this.quantity = quantity;
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

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", itemName=" + itemName + ", model=" + model + ", brand=" + brand + ", price="
				+ price + ", quantity=" + quantity + "]";
	}
}
