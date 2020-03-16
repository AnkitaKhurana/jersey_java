package com.ankitakhurana.hrManagement.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class User {
	@Id
	private int id;

	@Min(3)
	@Max(50)
	@NotBlank(message = "Username cannot be blank")
	private String username;

	@Min(3)
	@Max(50)
	@NotBlank(message = "Password cannot be blank")
	private String password;

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
