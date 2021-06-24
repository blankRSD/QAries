package com.teamone.webapp.beancretor;

import javax.servlet.http.HttpServletRequest;

import com.teamone.postgres.entity.User;

public class LoginCretor {
	private LoginCretor() {
	}
	public static User createLoginBean(HttpServletRequest request) {
		User login = new User();
		login.setUsername(request.getParameter("uname"));
		login.setPassword(request.getParameter("password"));
		return login;
	}
}
