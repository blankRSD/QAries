package com.teamone.webapp.beancretor;

import javax.servlet.http.HttpServletRequest;

import com.teamone.postgres.entity.User;

public class LoginCretor {
	private LoginCretor() {
	}
	public static User createLoginBean(HttpServletRequest request) {
		User userLogin = new User();
		userLogin.setEmail(request.getParameter("email"));
		userLogin.setPassword(request.getParameter("password"));
		return userLogin;
	}
}
