package com.harashit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.*;

import com.harashit.dao.QuestionDOO;
import com.harashit.entity.Question;
import com.harashit.interfaces.IQuestionDOO;

@WebServlet("/insertdata")
public class InsertDataServlet extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int val = Integer.parseInt(request.getParameter("questionId"));
		IQuestionDOO dao = new QuestionDOO();
		Question question = new Question();
		question.setQuestionId(val);
		question.setTitle("hvdhqbdjwkh");
		question.setDescription("nejqfbfqjFJ");
		question.setVotes(10);
		question.setUserId(3);
		boolean alpha = dao.insertOne(question);
		if (alpha) {
			System.out.println("i am here ");
			request.getRequestDispatcher("home").forward(request, response);
		} else {
			out.println("<h2 style='color:red'>Could not " + "be inserted </h2>");
			request.getRequestDispatcher("insertquestion.html").include(request, response);
		}
		
	}

}
