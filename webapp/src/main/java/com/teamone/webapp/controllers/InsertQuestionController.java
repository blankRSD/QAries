package com.teamone.webapp.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teamone.mongodb.dao.QuestionDOO;
import com.teamone.mongodb.entity.Question;
import com.teamone.mongodb.interfaces.IQuestionDOO;

@WebServlet("/insert-question")
public class InsertQuestionController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		//int val = Integer.parseInt(request.getParameter("questionId"));
		String title = request.getParameter("questiontitle");
		String description = request.getParameter("questiondescription");
		
		IQuestionDOO dao = new QuestionDOO();
		Question question = new Question();
		//question.setQuestionId(val);
		question.setTitle(title);
		question.setDescription(description);
		//question.setVotes(10);
		HttpSession session = request.getSession();
		int userid=Integer.parseInt(session.getAttribute("userid").toString());
		question.setUserId(userid);
		
		boolean alpha = dao.insertOne(question);
		if (alpha) {
			request.getRequestDispatcher("question").forward(request, response);
		} else {
			request.getRequestDispatcher("question").include(request, response);
		}
		
	}
}
