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

@WebServlet("/registration")
public class RegistrationController extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		
		
		HttpSession session = req.getSession();
		
		String registerMessage = "";
		
		if(session.isNew()) {
			IUserDAO dao = new UserDAO();
			dao.insert(new User(username, email, password));
			
			session.setAttribute("username", username);
			session.setAttribute("email", email);
			registerMessage = "Successfully registered";
		}
		else {
			registerMessage = "You are already registered";
			session.invalidate();
		}
		
		resp.setContentType("text/html");
		req.setAttribute("registerMessage", registerMessage);
		req.getRequestDispatcher("WEB-INF/views/dashboard.jsp").forward(req, resp);
		
		
	}
}
