package com.harashit.client;

import com.harashit.dao.AnswerDOO;
import com.harashit.entity.Answer;
import com.harashit.interfaces.IAnswerDOO;

public class App2 {
	public static void main(String[] args) {
		Answer answer = new Answer(2,110,"Answer is here",10,9,null,true);
		IAnswerDOO dao = new AnswerDOO();

//		if (dao.insertOne(answer)) {
//			System.out.println("done");
//		} else {
//			System.out.println("Not done");
//		}

		dao.getAllAnswers().forEach((o) -> System.out.println(o));
	}

}
