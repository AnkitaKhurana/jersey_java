package com.ankitakhurana.hrManagement.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ankitakhurana.hrManagement.models.User;
import com.ankitakhurana.hrManagement.services.UserService;

@Controller
public class UserController {
	@Autowired
	private HttpSession httpSession;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView validateUser(@Valid User user, BindingResult result) {

		System.out.println(result.hasErrors());
		if (result.hasErrors()) {
			System.out.println(user);
			ModelAndView mav = new ModelAndView("error.jsp");
			return mav;
		} else {

			User userFound = UserService.findUser(user);
			if (userFound != null) {
				httpSession.setAttribute("user", userFound);
				ModelAndView mav = new ModelAndView("redirect:employee");
				return mav;
			} else {
				return getMethod();
			}

		}

	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getMethod() {
		ModelAndView mav = new ModelAndView("index.jsp");
		return mav;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logoutMethod() {
		httpSession.setAttribute("user", null);
		ModelAndView mav = new ModelAndView("index.jsp");
		return mav;
	}

}
