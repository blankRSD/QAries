package com.harashit.controller;

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

import com.harashit.dao.AnswerDOO;
import com.harashit.dao.QuestionDOO;
import com.harashit.entity.Answer;
import com.harashit.entity.Question;
import com.harashit.interfaces.IAnswerDOO;
import com.harashit.interfaces.IQuestionDOO;

@WebServlet("/insertanswer")
public class InsertAnswerController extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		int val = Integer.parseInt(request.getParameter("answerId"));
		String description = request.getParameter("answerdescription");
		IAnswerDOO dao = new AnswerDOO();
		Answer answer = new Answer();
		answer.setAnswerId(val);
		answer.setDescription(description);
//		request.setParameter("qid", 6);

		boolean alpha = dao.insertOne(answer);
		if (alpha) {

//			String url = "question-details?qid='" + session.getAttribute("qid") + "'";
//			RequestDispatcher rd = request.getRequestDispatcher(url);
//			rd.forward(request, response);



			request.getRequestDispatcher("question-details?qid='" + session.getAttribute("qid") + "'").forward(request,
					response);
		} else {
			out.println("<h2 style='color:red'>Could not " + "be inserted </h2>");
			request.getRequestDispatcher("home-page").include(request, response);
		}
		
	}

}
