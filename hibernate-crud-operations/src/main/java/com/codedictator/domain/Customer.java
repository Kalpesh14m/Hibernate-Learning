package com.codedictator.domain;

public class Customer {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private Long mobile;

	public Customer() {
		// Do nothing
	}

	public Customer(String firstName, String lastName, String email, Long mobile) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
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

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "ID :" + id + "\nFirstName :" + firstName + "\nLastName :" + lastName + "\nEmail :" + email
				+ "\nMobile :" + mobile;
	}
}
