package com.lmo.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "user_info", schema = "rams")
public class User {
	@Column(name = "user_id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull
	private String empname;

	private String empdesc;
	@Email
	@NotNull
	private String email;

	protected User() {
	}

	public User(long id, @NotNull String empname, String empdesc, @Email @NotNull String email) {
		super();
		this.id = id;
		this.empname = empname;
		this.empdesc = empdesc;
		this.email = email;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the empname
	 */
	public String getEmpname() {
		return empname;
	}

	/**
	 * @param empname the empname to set
	 */
	public void setEmpname(String empname) {
		this.empname = empname;
	}

	/**
	 * @return the empdesc
	 */
	public String getEmpdesc() {
		return empdesc;
	}

	/**
	 * @param empdesc the empdesc to set
	 */
	public void setEmpdesc(String empdesc) {
		this.empdesc = empdesc;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", empname=" + empname + ", empdesc=" + empdesc + ", email=" + email + "]";
	}

}
