package com.codedictator.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "product")
@Table(name = "PRODUCT_MASTER5")
public class Product {
	private Long id;
	private String name;
	private String model;
	private String brand;
	private Double price;
	private Set<Color> colors;

	public Product() {
		// Do Nothing
	}

	public Product(String name, String model, String brand, Double price) {
		super();
		this.name = name;
		this.model = model;
		this.brand = brand;
		this.price = price;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCT_ID")
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

	@Column(name = "MODEL")
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Column(name = "BRAND")
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Column(name = "PRICE")
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name = "PRODUCT_COLOR_MASTER5", joinColumns = {
			@JoinColumn(columnDefinition = "PRODUCT_ID") }, inverseJoinColumns = {
					@JoinColumn(columnDefinition = "COLOR_ID") })

	public Set<Color> getColors() {
		return colors;
	}

	public void setColors(Set<Color> colors) {
		this.colors = colors;
	}
}
