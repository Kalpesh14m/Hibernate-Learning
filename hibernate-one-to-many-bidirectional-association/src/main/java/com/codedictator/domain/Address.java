package com.codedictator.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "address")
@Table(name = "ADDRESS_MASTER10")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String houseNo;
	private String street;
	private String city;
	private String landmark;
	private String state;
	private Long zipcode;
	private Customer customer;

	public Address() {
		// Do Nothing
	}

	public Address(String houseNo, String street, String city, String landmark, String state, Long zipcode) {
		super();
		this.houseNo = houseNo;
		this.street = street;
		this.city = city;
		this.landmark = landmark;
		this.state = state;
		this.zipcode = zipcode;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ADDRESS_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "HOUSE_NO")
	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	@Column(name = "STREET")
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Column(name = "CITY")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "LANDMARK")
	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	@Column(name = "STATE")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "ZIPCODE")
	public Long getZipcode() {
		return zipcode;
	}

	public void setZipcode(Long zipcode) {
		this.zipcode = zipcode;
	}

	@ManyToOne
	@JoinColumns(value = @JoinColumn(name = "CUSTOMER_ID"))
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Address ID: " + id + "\nHouse No: " + houseNo + "\nStreet: " + street + "\nCity: " + city
				+ "\nLandmark: " + landmark + "\nState: " + state + "\nZipcode: " + zipcode;
	}
}
