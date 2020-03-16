package com.ankitakhurana.hrManagement.models;

import java.util.Date;

public class Employee {
	
	@Override
	public String toString() {
		return "Employee [emp_code=" + emp_code + ", emp_name=" + emp_name + ", location=" + location + ", email="
				+ email + ", dob=" + dob + "]";
	}

	private int emp_code;
	private String emp_name;
	private String location;
	private String email;
	private Date dob;

	public int getEmp_code() {
		return emp_code;
	}

	public void setEmp_code(int emp_code) {
		this.emp_code = emp_code;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

}
