package com.example.transmit.pojo;

import java.io.Serializable;

public class User implements Serializable{
	private int age;
	private String name;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User() {
		super();
	}

	public User(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
}
