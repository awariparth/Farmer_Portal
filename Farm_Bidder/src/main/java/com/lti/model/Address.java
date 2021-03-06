package com.lti.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Address implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="address_sequence")
	@SequenceGenerator(name="address_sequence",sequenceName="address_sequence")
	@Column
private int addressId;
@Column
@NotEmpty(message = "Address cannot be empty!")
private String localAddress;
@Column
@NotEmpty(message = "City cannot be empty!")
private String city;

@OneToOne(cascade=CascadeType.ALL)
private State state;

public int getAddressId() {
	return addressId;
}

public void setAddressId(int addressId) {
	this.addressId = addressId;
}

public String getLocalAddress() {
	return localAddress;
}

public void setLocalAddress(String localAddress) {
	this.localAddress = localAddress;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public State getState() {
	return state;
}

public void setState(State state) {
	this.state = state;
}

@Override
public String toString() {
	return "Address [addressId=" + addressId + ", localAddress=" + localAddress + ", city=" + city + ", state=" + state
			+ "]";
}

public Address(int addressId, String localAddress, String city, State state) {
	super();
	this.addressId = addressId;
	this.localAddress = localAddress;
	this.city = city;
	this.state = state;
}

public Address() {
	super();
	// TODO Auto-generated constructor stub
}


}
