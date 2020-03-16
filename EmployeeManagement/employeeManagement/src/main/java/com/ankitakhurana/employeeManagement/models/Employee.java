package com.ankitakhurana.employeeManagement.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Employee {

	@Override
	public String toString() {
		return "Employee [emp_code=" + emp_code + ", emp_name=" + emp_name + ", location=" + location + ", email="
				+ email + ", dob=" + dob + "]";
	}

	@Column(name = "emp_code")
	private int emp_code;
	@Column(name = "emp_name")
	private String emp_name;
	@Column(name = "location")
	private String location;
	@Column(name = "email")
	private String email;
	@Column(name = "dob")
	private Date dob;

	@Id
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
