package com.teamone.mongodb.client;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.teamone.mongodb.dao.QuestionDOO;
import com.teamone.mongodb.entity.Question;
import com.teamone.mongodb.interfaces.IQuestionDOO;



public class App {
	public static void main(String[] args) {

		Question question = new Question();
		IQuestionDOO dao = new QuestionDOO();
//		
//		question.setQuestionId(19);
//		question.setTitle("hvdhqbdjqjevn");
//		question.setDescription("nejqevgwfbf");
//		question.setVotes(5);
//		question.setUserId(3);
//		boolean alpha = dao.insertOne(question);
//		if (alpha) {
//			System.out.println("Done");
//		} else {
//			System.out.println("Not done");
//		}

		System.out.println("-------------------------------------------------------->> ");

//		List<Question> questionList = new ArrayList<Question>();
//		Date dt = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String currentTime = sdf.format(dt);
//		questionList.add(new Question(3, "hello there", "habefjebj", 6, currentTime, 3));
//		questionList.add(new Question(4, "hello there4", "habefjebjwveg", 8, currentTime, 3));
//		questionList.add(new Question(5, "hello there5", "habefjebjwavg", 7, currentTime, 3));
//		questionList.add(new Question(6, "hello there6", "habefjebjawrg", 9, currentTime, 3));
//		boolean alpha = dao.insertMany(questionList);
//		if (alpha) {
//			System.out.println("Done");
//		} else {
//			System.out.println("Not done");
//		}

//		int votes = 7;
//		Question questionFind = dao.getOneRecord(votes);
//		System.out.println(questionFind);

		System.out.println("------------------------------------------------------->>");
		dao.getAllQuestions().forEach((o) -> System.out.println(o));
		System.out.println("------------------------------------------------------->>");
//		dao.getQuestionsWithCondition(5, 100).forEach((o) -> System.out.println(o));
		System.out.println("------------------------------------------------------->>");
//		if (dao.updateQuestion()) {
//			System.out.println("done bhaiya");
//		} else {
//			System.out.println("Not done");
//		}
		System.out.println("------------------------------------------------------->>");
//		if (dao.deleteOne(2)) {
//			System.out.println("done sir");
//		} else {
//			System.out.println("not done ");
//		}

//		if (dao.upsertFuntion(3)) {
//			System.out.println("done bhaiya ji");
//		} else {
//			System.out.println("Not done ji ");
//		}

	}




}
