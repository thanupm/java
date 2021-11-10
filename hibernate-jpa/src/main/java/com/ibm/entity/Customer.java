package com.ibm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class Customer {
@Id
@Column(name = "cid")
private int custId;

@Column(name = "cname", length = 30)
private String custName;

@Column(length = 15)
private String city;

public int getCustId() {
	return custId;
}

public void setCustId(int custId) {
	this.custId = custId;
}

public String getCustName() {
	return custName;
}

public void setCustName(String custName) {
	this.custName = custName;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}


}
