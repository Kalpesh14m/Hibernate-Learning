package com.codedictator.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="color")
@Table(name="COLOR_MASTER4")
public class Color {
	private Long id;
	private String name;
	
	public Color() {
		//Do Nothing
	}
	public Color(String name) {
		super();
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COLOR_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="COLOR_NAME", unique=true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Color ID: "+id
				+"\nColor Name: "+name;
	}
}
