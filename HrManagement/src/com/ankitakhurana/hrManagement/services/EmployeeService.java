package com.ankitakhurana.hrManagement.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.*;
import com.ankitakhurana.hrManagement.models.Employee;

public class EmployeeService {

	public static List<Employee> getAllEmployees() {
		try {

			List<Employee> emps = new ArrayList<Employee>();
			URL url = new URL("http://localhost:8080/employeeManagement/employee");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			output = bufferedReader.readLine();

			JSONArray obj = new JSONArray(output);
			for (Object ob : obj) {

				JSONObject emp = (JSONObject) ob;
				Employee e = new Employee();
				e.setEmp_code(emp.getInt("emp_code"));
				e.setEmp_name(emp.getString("emp_name"));
				e.setLocation(emp.getString("location"));
				e.setEmail(emp.getString("email"));
				emps.add(e);

			}
			conn.disconnect();
			return emps;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return null;
		}

	}

	public static Employee getEmployee(int empCode) {

		try {
			URL url = new URL("http://localhost:8080/employeeManagement/employee/" + empCode);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			output = bufferedReader.readLine();

			JSONObject emp = new JSONObject(output);

			Employee e = new Employee();
			e.setEmp_code(emp.getInt("emp_code"));
			e.setEmp_name(emp.getString("emp_name"));
			e.setLocation(emp.getString("location"));
			e.setEmail(emp.getString("email"));

			conn.disconnect();
			return e;

		} catch (Exception e) {
			return null;

		}

	}

	public static void updateEmployee(Employee employee) {
		try {

			JSONObject json = new JSONObject();
			json.put("emp_code", employee.getEmp_code());
			json.put("emp_name", employee.getEmp_name());
			json.put("location", employee.getLocation());
			json.put("email", employee.getEmail());

			final URL url = new URL("http://localhost:8080/employeeManagement/employee");
			final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("PUT");
			conn.setRequestProperty("Content-Type", "application/json");
			final OutputStream os = conn.getOutputStream();
			os.write(json.toString().getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			output = bufferedReader.readLine();
			System.out.println(output);
			conn.disconnect();

		} catch (Exception e) {

		}

	}

}
