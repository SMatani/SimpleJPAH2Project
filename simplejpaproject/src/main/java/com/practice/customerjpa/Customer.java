package com.practice.customerjpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long Id;
	
	private String firstname;
	private String lastname;
	
	public Customer(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}

	
	public Customer() {
		super();
	}

	public Long getId() {
		return Id;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}
	
	@Override
	public String toString() {
		return "CustomerRepository [firstname=" + firstname + ", lastname=" + lastname + "]";
	}


	

}
