package com.ankitakhurana.hrManagement.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ankitakhurana.hrManagement.models.Employee;
import com.ankitakhurana.hrManagement.services.EmployeeService;

@Controller
public class EmployeeController {

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public ModelAndView getMethod() {
		ModelAndView mav = new ModelAndView("employee.jsp");
		List<Employee> employees = EmployeeService.getAllEmployees();
		mav.addObject("employees", employees);
		return mav;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editMethod(@RequestParam("empCode") int empCode) {
		ModelAndView mav = new ModelAndView("edit.jsp");
		Employee emp = EmployeeService.getEmployee(empCode);
		mav.addObject("employee", emp);
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/update")
	public String updateEmployee(@ModelAttribute("employee") @Validated Employee employee, final BindingResult br) {
		if (br.hasErrors()) {
			return "edit";
		} else {
			EmployeeService.updateEmployee(employee);
			return "redirect:/employee";
		}
	}

}
