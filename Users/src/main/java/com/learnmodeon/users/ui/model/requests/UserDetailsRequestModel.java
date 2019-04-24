package com.learnmodeon.users.ui.model.requests;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



public class UserDetailsRequestModel {
	@Digits(fraction = 2, integer = 6)
	private long id;
	@NotNull(message="Name Cannot be null!")
	private String name;
	@Size(min=4,max=6,message="dept must be between 4 to 6 characters!")
	private String dept;
	private float salary;
	@NotNull(message="Email cannot be null!")
	@Email
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

}
