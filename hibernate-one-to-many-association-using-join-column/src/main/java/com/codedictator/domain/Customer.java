package com.codedictator.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER_MASTER8")
public class Customer implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CUSTOMER_ID")
	private Long id;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	private String email;
	private Long mobile;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="CUSTOMER_ID")
	private List<Address> addresses;
	
	public Customer() {
		//Do Nothing
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
	
	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "Customer ID: "+id
				+"\nFirst Name: "+firstName
				+"\nLast Name: "+lastName
				+"\nEmail: "+email
				+"\nMobile: "+mobile;
	}
}
