package com.jsp.management.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class EventName {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String sport_name;
private int timeslot1;
private int timeslot2;
private int timeslot3;
private int timeslot4;
private int charges;


@ManyToMany(mappedBy = "eventNames")
private List<User> users;
@ManyToOne(cascade = CascadeType.ALL)
private Branch branch;
public EventName(EventName eventName) {
	// TODO Auto-generated constructor stub
	this.id=eventName.id;
	this.sport_name=eventName.sport_name;
}

public EventName() {
	super();
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public String getSport_name() {
	return sport_name;
}
public void setSport_name(String sport_name) {
	this.sport_name = sport_name;
}
public int getTimeslot1() {
	return timeslot1;
}
public void setTimeslot1(int timeslot1) {
	this.timeslot1 = timeslot1;
}
public int getTimeslot2() {
	return timeslot2;
}
public void setTimeslot2(int timeslot2) {
	this.timeslot2 = timeslot2;
}
public int getTimeslot3() {
	return timeslot3;
}
public void setTimeslot3(int timeslot3) {
	this.timeslot3 = timeslot3;
}
public int getTimeslot4() {
	return timeslot4;
}
public void setTimeslot4(int timeslot4) {
	this.timeslot4 = timeslot4;
}
public List<User> getUsers() {
	return users;
}
public void setUsers(List<User> users) {
	this.users = users;
}
public Branch getBranch() {
	return branch;
}
public void setBranch(Branch branch) {
	this.branch = branch;
}

public int getCharges() {
	return charges;
}

public void setCharges(int charges) {
	this.charges = charges;
}

}
