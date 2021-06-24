package com.teamone.webapp.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teamone.postgres.entity.User;
import com.teamone.webapp.beancretor.LoginCretor;
import com.teamone.webapp.services.LoginService;


@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		User login = LoginCretor.createLoginBean(req);
		
		if(new LoginService().loginValidate(login)) {
			HttpSession session   = req.getSession();
			session.setAttribute("name", req.getParameter("username"));
			req.setAttribute("registerMessage", "successful login");
			req.getRequestDispatcher("WEB-INF/views/dashboard.jsp").forward(req, resp);
		}else {
			resp.getWriter().println("<h2 style='coloe:red'>Sorry Invalid "
					+ "Credentials Please Enter Again</h2>");
			
			req.getRequestDispatcher("WEB-INF/views/dashboard.jsp").include(req, resp);
			
		}
		
		
	}

}
