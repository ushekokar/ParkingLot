package com.parking.controller;

public class Driver {
	int age;
	String name;
	public Driver(String name,int age) {
		this.name= name;
		this.age=age;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
