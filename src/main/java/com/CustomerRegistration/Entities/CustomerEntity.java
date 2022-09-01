package com.CustomerRegistration.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Registered_Customers")
public class CustomerEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name= "Customer_userNames")
	private String UserName;
	@Column(name= "Customer_Emails")
	private String Email;
	@Column(name= "Customer_PhoneNumbers")
	private String PhoneNumber;
	
	public CustomerEntity() {
		
	}
	
	public CustomerEntity(String userName, String email, String phoneNumber) {
		super();
		UserName = userName;
		Email = email;
		PhoneNumber = phoneNumber;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	
	
}
