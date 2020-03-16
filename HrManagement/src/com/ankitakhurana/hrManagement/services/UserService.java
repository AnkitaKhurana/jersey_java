package com.ankitakhurana.hrManagement.services;

import javax.validation.Valid;

import com.ankitakhurana.hrManagement.models.User;

public class UserService {

	public static User findUser(@Valid User user) {
		try {
			return DatabaseService.GetUser(user.getUsername(), user.getPassword());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

}
