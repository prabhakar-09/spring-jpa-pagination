package com.spring.pagination.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Person {

	@Id @GeneratedValue
	private Integer id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	
	/*
	 * ALL is a cascading type in Hibernate that specifies that all state
	 * transitions (create, update, delete, and refresh) should be cascaded from the
	 * parent entity to the child entities. When CascadeType. ALL is used, and any
	 * operation performed on the parent entity will be automatically propagated to
	 * all child entities.
	 */
	@OneToOne(cascade = CascadeType.ALL) // Defines that each person has one address or one address belongs to one person
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;
	
	private Person() {
		
	}
	
	 public Person(String firstName, String lastName, String phoneNumber, String email, Address address) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.phoneNumber = phoneNumber;
	        this.email = email;
	        this.address = address;
	 }
	
	public Person(Integer id, String firstName, String lastName, String phoneNumber, String email, Address address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber="
				+ phoneNumber + ", email=" + email + ", address=" + address + "]";
	}
	
}
