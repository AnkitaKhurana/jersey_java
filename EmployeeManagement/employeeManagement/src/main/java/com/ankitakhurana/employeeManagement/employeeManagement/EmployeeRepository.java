package com.ankitakhurana.employeeManagement.employeeManagement;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ankitakhurana.employeeManagement.models.Employee;
import com.ankitakhurana.employeeManagement.services.EmployeeService;

@Path("employee")
public class EmployeeRepository {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployees() {
		List<Employee> emps = EmployeeService.getEmployees();
		return emps;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployee(@PathParam("id") int id) {
		Employee e = EmployeeService.getEmployee(id);
		if (e != null)
			return e;
		else
			return new Employee();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Employee editEmployee(Employee emp) {
		System.out.print(emp);
		EmployeeService.editEmployee(emp);
		return emp;
	}
}
