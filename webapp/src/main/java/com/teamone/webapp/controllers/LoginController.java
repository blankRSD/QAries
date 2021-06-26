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
import com.teamone.webapp.beancreator.LoginCreator;
import com.teamone.webapp.services.LoginService;


@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, res);
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		User userLogin = LoginCreator.createLoginBean(req);
		
		if(new LoginService().validate(userLogin)) {
			
			HttpSession session   = req.getSession();
			IUserDAO dao = new UserDAO();
			
			User newUser= dao.getByEmail(userLogin.getEmail());
			
			session.setAttribute("name", newUser.getUsername());
			session.setAttribute("email", newUser.getEmail());
			session.setAttribute("userid", newUser.getUserId());
			
			req.setAttribute("registerMessage", "successful login");
			req.getRequestDispatcher("WEB-INF/views/dashboard.jsp").forward(req, res);
			
		}else {
			res.getWriter().println("<h2 style='color:red'>Sorry Invalid "
					+ "Credentials Please Enter Again</h2>");
						
			req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, res);
		}
		
		
	}

}
