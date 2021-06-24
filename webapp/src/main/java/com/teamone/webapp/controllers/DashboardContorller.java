package com.teamone.webapp.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teamone.mongodb.contracts.IQuestionDao;
import com.teamone.mongodb.dao.QuestionDAO;
import com.teamone.mongodb.entity.Question;

@WebServlet("/dashboard")
public class DashboardContorller extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		IQuestionDao questionDao = new QuestionDAO();
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		for(Question user: questionDao.getAll()) {	
			out.println("<li>" + user.getDescription() + "</li>");
		}
		out.println("</body>");
		out.println("</html>");
	}
}
