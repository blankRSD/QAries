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

import com.harashit.dao.QuestionDOO;
import com.harashit.entity.Question;
import com.harashit.interfaces.IQuestionDOO;

@WebServlet("/home-page")
public class HomeController extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		HttpSession session = req.getSession();
//		System.out.println(session.hashCode());
		if (session.isNew()) {
//			resp.getWriter().print("<h1>Error</h1>");
		} else {
			IQuestionDOO dao = new QuestionDOO();
			List<Question> questions = dao.getAllQuestions();

			resp.getWriter().print("<h2>Welcome User " + session.getAttribute("name") + "</h2>");
			for(Question question: questions) {
//				req.setAttribute("questionId", question.getQuestionId());
				resp.getWriter()
						.print("<a href='question-details?qid="+ question.getQuestionId() + "' method='get'><p>Question title:"
								+ question.getTitle() + "</p></a>");

			}
//			resp.getWriter().print("<h2>Welcome User " + session.getAttribute("name") + "</h2>");
//			PrintWriter out = resp.getWriter();
//			out.println("<a href=\"./insertquestion.html\">insertquestion</a>");
			resp.getWriter().print("<form action='insertdata' method='post'>");
			resp.getWriter().print("<h2>Enter Question Id </h2>> ");
			resp.getWriter().print("<input type='text' name='questionId' /> ");
			resp.getWriter().print("<h2>Enter Question Title </h2>> ");
			resp.getWriter().print("<input type='text' name='questiontitle' /> ");
			resp.getWriter().print("<h2>Enter Question description </h2>> ");
			resp.getWriter().print("<input type='text' name='questiondescription' /> ");
			resp.getWriter().print("<button>Submit</button> ");

		}
	}
}
