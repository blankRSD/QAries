package com.teamone.webapp.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teamone.postgres.entity.User;
import com.teamone.webapp.beancreator.RegistrationCreator;
import com.teamone.webapp.services.RegistrationService;

@WebServlet("/registration")
public class RegistrationController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		req.getRequestDispatcher("WEB-INF/views/registration.jsp").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User user = RegistrationCreator.createRegistrationBean(req);
		
		String notification = "";
		
		resp.setContentType("text/html");

		if(RegistrationService.exists(user)) {
			notification = "You are already Registered. Please Login.";
			req.setAttribute("notification", notification);
			req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);
		}
		else {
			RegistrationService.save(user);
			notification = "Successfully Registered";
			req.setAttribute("notification", notification);
			req.getRequestDispatcher("WEB-INF/views/dashboard.jsp").forward(req, resp);
		}
		
		
		
	}
}
