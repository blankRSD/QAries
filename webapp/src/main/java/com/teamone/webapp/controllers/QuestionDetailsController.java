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
		
		doPost(req, resp);
		
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		
		HttpSession session = req.getSession();
		session.setAttribute("qid", req.getParameter("qid"));
		
		if (session.isNew()) {
			
		} else {
			IQuestionDOO qdao = new QuestionDOO();
			Question question = qdao.getOneQuestionWithQuestionId(Integer.parseInt(req.getParameter("qid")));
			IAnswerDOO dao = new AnswerDOO();
			List<Answer> answers = dao.getAnswerWithQid(Integer.parseInt(req.getParameter("qid")));
			
			req.setAttribute("answers", answers);
			req.setAttribute("question", question);
			
			req.getRequestDispatcher("WEB-INF/views/question-detail.jsp").forward(req, resp);
			
			
		}
		
	}
}
