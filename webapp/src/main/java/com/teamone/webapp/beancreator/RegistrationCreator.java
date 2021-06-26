package com.teamone.webapp.beancreator;

import javax.servlet.http.HttpServletRequest;

import com.teamone.postgres.entity.User;

public class RegistrationCreator {

	private RegistrationCreator() {
	}
	
	public static User createRegistrationBean(HttpServletRequest request) {
		return new User(
			request.getParameter("username"),
			request.getParameter("email"),
			request.getParameter("password")
		);
	}
}
