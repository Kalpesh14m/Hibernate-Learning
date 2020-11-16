package com.codedictator.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_MASTER6")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCT_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;
	private String model;
	private String brand;
	private String category;
	private Double price;

	public Product() {
		// Do Nothing
	}

	public Product(String name, String model, String brand, String category, Double price) {
		super();
		this.name = name;
		this.model = model;
		this.brand = brand;
		this.category = category;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product ID: " + id + "\nName: " + name + "\nModel: " + model + "\nBrand: " + brand + "\nCategory: "
				+ category + "\nPrice: " + price;
	}
}
