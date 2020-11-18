package com.codedictator.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "color")
@Table(name = "COLOR_MASTER5")
public class Color {
	private Long id;
	private String name;
	private Set<Product> products;

	public Color() {
		// Do Nothing
	}

	public Color(String name) {
		super();
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COLOR_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "NAME", unique = true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany(mappedBy = "colors")
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Color ID: " + id + "\nColor Name:" + name;
	}

}
