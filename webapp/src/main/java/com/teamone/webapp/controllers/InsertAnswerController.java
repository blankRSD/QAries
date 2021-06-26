package com.teamone.webapp.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bson.*;

import com.teamone.mongodb.dao.AnswerDOO;
import com.teamone.mongodb.dao.QuestionDOO;
import com.teamone.mongodb.entity.Answer;
import com.teamone.mongodb.entity.Question;
import com.teamone.mongodb.interfaces.IAnswerDOO;
import com.teamone.mongodb.interfaces.IQuestionDOO;

@WebServlet("/insert-answer")
public class InsertAnswerController extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		
		int val = Integer.parseInt(request.getParameter("answerId"));
		String description = request.getParameter("answerdescription");
		int qid = Integer.parseInt(session.getAttribute("qid").toString());
		
		IAnswerDOO dao = new AnswerDOO();
		Answer answer = new Answer();
		answer.setAnswerId(val);
		answer.setDescription(description);
		answer.setQuestionId(qid);

		boolean alpha = dao.insertOne(answer);
		if (alpha) {
			request.getRequestDispatcher("question-detail?qid=" + session.getAttribute("qid")).forward(request, response);
		} else {
			request.getRequestDispatcher("home-page").include(request, response);
		}
		
	}

}
