package com.codedictator.domain;

import java.util.List;

public class Customer {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private List<Long> mobiles;

	public Customer() {
		// Do Nothing
	}

	public Customer(String firstName, String lastName, String email) {
		super();

		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Long> getMobiles() {
		return mobiles;
	}

	public void setMobiles(List<Long> mobiles) {
		this.mobiles = mobiles;
	}

	@Override
	public String toString() {
		return "Customer ID:" + id + "\nFirst Name:" + firstName + "\nLast Name:" + lastName + "\nEmail :" + email;
	}
}
