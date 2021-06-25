package com.harashit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.harashit.dao.AnswerDOO;
import com.harashit.dao.QuestionDOO;
import com.harashit.entity.Answer;
import com.harashit.entity.Question;
import com.harashit.interfaces.IAnswerDOO;
import com.harashit.interfaces.IQuestionDOO;

@WebServlet("/question-details")
public class QuestionDetailsController extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		resp.getWriter().print("Hello" + req.getParameter("qid"));
		
		HttpSession session = req.getSession();
		session.setAttribute("qid", req.getParameter("qid"));

		if (session.isNew()) {
//			resp.getWriter().print("<h1>Error</h1>");
		} else {
			IAnswerDOO dao = new AnswerDOO();
			List<Answer> answers = dao.getAllAnswers();

			resp.getWriter().print("<h2>Question Title:" + req.getParameter("qid") + "UserName : "
					+ session.getAttribute("userid") + "</h2>");
			for(Answer answer: answers) {
				resp.getWriter()
						.print("<p>Answer description:" + answer.getDescription() + "</p></a>");

			}

			resp.getWriter().print("<form action='insertanswer' method='post'>");
			resp.getWriter().print("<h2>Enter Answer Id </h2>> ");
			resp.getWriter().print("<input type='text' name='answerId' /> ");
			resp.getWriter().print("<h2>Enter Answer Description </h2>> ");
			resp.getWriter().print("<input type='text' name='answerdescription' /> ");

			resp.getWriter().print("<button>Submit</button> ");
		
		
		
		
		
		
		
		
		
		
//		resp.getWriter().print();
//		if (1 == 1) {
//			// send him/her to home page 
//			HttpSession session = req.getSession();
//			session.setAttribute("name", req.getParameter("uname"));
//			session.setAttribute("userid", 3);
//			session.setAttribute("Status", "Ok");
//			String URI = "index2.jsp";
//			req.getRequestDispatcher(URI).forward(req, resp);
////			req.getRequestDispatcher("").forward(req, resp);
//
//		}else {
//			resp.getWriter().println("<h2 style='coloe:red'>Sorry Invalid "
//					+ "Credentials Please Enter Again</h2>");
//			
//			req.getRequestDispatcher("login.html").include(req, resp);
//			
//		}
	}
}
}
