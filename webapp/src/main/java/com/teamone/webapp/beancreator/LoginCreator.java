package com.teamone.webapp.beancreator;

import javax.servlet.http.HttpServletRequest;

import com.teamone.postgres.entity.User;

public class LoginCreator {
	private LoginCreator() {
	}
	public static User createLoginBean(HttpServletRequest request) {
		User userLogin = new User();
		userLogin.setEmail(request.getParameter("email"));
		userLogin.setPassword(request.getParameter("password"));
		return userLogin;
	}
}
