package com.teamone.mongodb.client;

import com.teamone.mongodb.dao.AnswerDOO;
import com.teamone.mongodb.dao.QuestionDOO;
import com.teamone.mongodb.entity.Answer;
import com.teamone.mongodb.entity.Question;
import com.teamone.mongodb.interfaces.IAnswerDOO;
import com.teamone.mongodb.interfaces.IQuestionDOO;

public class App2 {
	public static void main(String[] args) {
		Answer answer = new Answer(200,11000,"Answer is here",10,9,null,true);
		IAnswerDOO dao = new AnswerDOO();
		
		IQuestionDOO qdao = new QuestionDOO();
		Question ques = qdao.getOneQuestionWithQuestionId(110);

//		if (dao.insertOne(answer)) {
//			System.out.println("done");
//		} else {
//			System.out.println("Not done");
//		}

		System.out.println(ques);
	}

}
