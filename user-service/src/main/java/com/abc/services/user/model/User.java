package com.abc.services.user.model;

public class User {

	private Long id;
	private String name;
	private String email;
	private int age;
	private String password;

	public User() {

	}
	
	public User(String name, int age, String email , String password) {

		this.name = name;
		this.age = age;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}
	
	public void setId(Long id) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail( String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return " [Customer id=" + id 
				+ ", name=" + name + ", email=" + email + "]";
	}

}
