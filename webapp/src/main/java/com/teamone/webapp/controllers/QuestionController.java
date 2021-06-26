package com.teamone.webapp.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teamone.mongodb.dao.QuestionDOO;
import com.teamone.mongodb.entity.Question;
import com.teamone.mongodb.interfaces.IQuestionDOO;

@WebServlet("/question")
public class QuestionController extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		HttpSession session = req.getSession();
		
		if(session.isNew()) {
			
		}
		else {
			IQuestionDOO dao = new QuestionDOO();
			List<Question> questions = dao.getAllQuestions();
			
			req.setAttribute("questions", questions);
			req.getRequestDispatcher("WEB-INF/views/question.jsp").forward(req, resp);
		}
	}

}
