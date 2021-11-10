package com.ibm.entity;
import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {
	@Id
	@GeneratedValue
	private int pid;
	
	@Column(name="pname", length = 30)
	private String name;
	
	private int age;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
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
	
}
