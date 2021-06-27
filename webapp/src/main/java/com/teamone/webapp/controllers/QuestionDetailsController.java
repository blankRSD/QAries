package com.teamone.webapp.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teamone.mongodb.dao.AnswerDOO;
import com.teamone.mongodb.dao.QuestionDOO;
import com.teamone.mongodb.entity.Answer;
import com.teamone.mongodb.entity.Question;
import com.teamone.mongodb.interfaces.IAnswerDOO;
import com.teamone.mongodb.interfaces.IQuestionDOO;

@WebServlet("/question-detail")
public class QuestionDetailsController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//doPost(req, resp);
		
		resp.setContentType("text/html");
		
		HttpSession session = req.getSession();
		session.setAttribute("qid", req.getParameter("qid"));
		//String qid=String.valueOf();
		
		if (session.getId()==session.getAttribute("sessionid")) {
			IQuestionDOO qdao = new QuestionDOO();
			Question question = qdao.getOneQuestionWithQuestionId(req.getParameter("qid"));
			IAnswerDOO dao = new AnswerDOO();
			List<Answer> answers = dao.getAnswerWithQid(req.getParameter("qid"));
			
			req.setAttribute("answers", answers);
			req.setAttribute("question", question);
			
			req.getRequestDispatcher("WEB-INF/views/question-detail.jsp").forward(req, resp);
			
			
		} 
		req.getRequestDispatcher("WEB-INF/views/invalidlogin.jsp").forward(req, resp);
		
		
		
	}
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		
		//int val = Integer.parseInt(request.getParameter("answerId"));
		String description = request.getParameter("answerdescription");
		String qid = session.getAttribute("qid").toString();
		
		IAnswerDOO dao1 = new AnswerDOO();
		Answer answer = new Answer();
		//answer.setAnswerId(val);
		answer.setDescription(description);
		answer.setQuestionId(qid);

		boolean alpha = dao1.insertOne(answer);
		if (alpha) {
			
			IQuestionDOO qdao = new QuestionDOO();
			Question question = qdao.getOneQuestionWithQuestionId(qid);
			IAnswerDOO dao = new AnswerDOO();
			List<Answer> answers = dao.getAnswerWithQid(qid);
			
			request.setAttribute("answers", answers);
			request.setAttribute("question", question);
			
			request.getRequestDispatcher("WEB-INF/views/question-detail.jsp").forward(request, response);
			
			//request.getRequestDispatcher("question-detail?qid=" + session.getAttribute("qid")).forward(request, response);
		} else {
			request.getRequestDispatcher("WEB-INF/views/question-detail.jsp").forward(request, response);
		}
		
	}
		
		
	}

