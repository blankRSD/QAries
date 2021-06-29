  package com.teamone.webapp.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teamone.postgres.contracts.IUserDAO;
import com.teamone.postgres.dao.UserDAO;
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
			HttpSession session   = req.getSession();
			IUserDAO dao = new UserDAO();
			User newUser= dao.getByEmail(user.getEmail());
			session.setAttribute("name", newUser.getUsername());
			session.setAttribute("email", newUser.getEmail());
			session.setAttribute("userid", newUser.getUserId());
			session.setAttribute("sessionid", session.getId());
			notification = "Successfully Registered";
			req.setAttribute("notification", notification);
			req.getRequestDispatcher("WEB-INF/views/dashboard.jsp").forward(req, resp);
		}
		
		
		
	}
}
