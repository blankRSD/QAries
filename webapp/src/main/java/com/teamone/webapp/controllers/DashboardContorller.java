package com.teamone.webapp.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/dashboard")
public class DashboardContorller extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html");
		
		//HttpSession session1 = req.getSession();
		//session1.invalidate();
		HttpSession session = req.getSession();
		if (session.getId()==session.getAttribute("sessionid")) {
			req.getRequestDispatcher("WEB-INF/views/dashboard.jsp").forward(req, res);
	
			
		} 
		req.getRequestDispatcher("WEB-INF/views/invalidlogin.jsp").forward(req, res);
		
	}
}