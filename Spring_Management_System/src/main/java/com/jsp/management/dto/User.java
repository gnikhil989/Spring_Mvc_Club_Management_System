package com.jsp.management.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String name;
private String email;
private String branch;
private String payment;
private String user_password;
private int charges;
@OneToOne(cascade =  CascadeType.ALL)
private Branch branch2;
@ManyToMany(cascade = CascadeType.ALL)
private List<EventName> eventNames;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getBranch() {
	return branch;
}
public void setBranch(String branch) {
	this.branch = branch;
}
public String getPayment() {
	return payment;
}
public void setPayment(String payment) {
	this.payment = payment;
}
public String getUser_password() {
	return user_password;
}
public void setUser_password(String user_password) {
	this.user_password = user_password;
}
public Branch getBranch2() {
	return branch2;
}
public void setBranch2(Branch branch2) {
	this.branch2 = branch2;
}
public List<EventName> getEventNames() {
	return eventNames;
}
public void setEventNames(List<EventName> eventNames) {
	this.eventNames = eventNames;
}
public int getCharges() {
	return charges;
}
public void setCharges(int charges) {
	this.charges = charges;
}

}
