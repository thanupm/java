package com.ibm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pass")
public class Passanger {

	@Id
	private int id;
	@Column(name = "passName" , length = 20)
	private String name;
	private int age;

	@ManyToOne
	@JoinColumn(name = "tck")
	private Ticket tck;

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Ticket getTck() {
		return tck;
	}

	public void setTck(Ticket tck) {
		this.tck = tck;
	}
	
	
	
}