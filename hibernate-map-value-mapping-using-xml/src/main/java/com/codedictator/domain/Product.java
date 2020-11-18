package com.codedictator.domain;

import java.util.Map;

public class Product {
	private Long id;
	private String name;
	private String model;
	private String brand;
	private String category;
	private Double price;
	private Map<String, String> props;

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

	public Map<String, String> getProps() {
		return props;
	}

	public void setProps(Map<String, String> props) {
		this.props = props;
	}

	@Override
	public String toString() {
		return "Product ID:" + id + "\n Name:" + name + "\nModel:" + model + "\nBrand :" + brand + "\nCategory :"
				+ category + "\nPrice :" + price;
	}
}
