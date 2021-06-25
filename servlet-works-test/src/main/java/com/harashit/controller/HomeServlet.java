package com.harashit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mongodb.session.SessionContext;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		response.getWriter()
				.print("<h2>The dtaa for questionId= " + request.getParameter("questionId") + " is inserted by </h2>"
						+ session.getAttribute("name"));
	}

}
