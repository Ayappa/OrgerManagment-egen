package com.egen.example.egen.models;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.egen.example.egen.pojo.Address;

import lombok.Data;

@Entity
@Data
@Table(name="users")
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	
//	@Column(name = "firstName")
	
	private String firstName;
	
//	@Column(name = "lastName")
	
	private String lastName;
	
	
	private String password;
	
	
	private String email;
	
    @Embedded
	private Address BillingAddress;
	
   
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getBillingAddress() {
		return BillingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		BillingAddress = billingAddress;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
				+ ", email=" + email + ", BillingAddress=" + BillingAddress 
				+ "]";
	}

	public User(Integer id, String firstName, String lastName, String password, String email, Address billingAddress) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		BillingAddress = billingAddress;
	}

	public User() {
		super();
	}
	
	
}
