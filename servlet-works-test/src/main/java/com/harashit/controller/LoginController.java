package com.harashit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login-validate")
public class LoginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		if (1 == 1) {
			// send him/her to home page 
			HttpSession session = req.getSession();
			session.setAttribute("name", req.getParameter("uname"));
			session.setAttribute("userid", 3);
			session.setAttribute("Status", "Ok");
			String URI = "index2.jsp";
			req.getRequestDispatcher(URI).forward(req, resp);
//			req.getRequestDispatcher("").forward(req, resp);

		}else {
			resp.getWriter().println("<h2 style='coloe:red'>Sorry Invalid "
					+ "Credentials Please Enter Again</h2>");
			
			req.getRequestDispatcher("login.html").include(req, resp);
			
		}
	}
	
}
