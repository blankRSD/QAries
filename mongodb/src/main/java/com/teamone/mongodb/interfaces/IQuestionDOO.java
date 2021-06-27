package com.teamone.mongodb.interfaces;


import java.util.List;

import com.teamone.mongodb.entity.Question;



public interface IQuestionDOO {
	public boolean insertOne(Question question);
	
	public boolean insertMany(List<Question> questionList);

	public Question getOneQuestionWithQuestionId(String id);

	public Question getOneRecord(int votes);

	public List<Question> getAllQuestions();

	public List<Question> getQuestionsWithCondition(int votes, int limit);

	public boolean updateQuestion();

	public boolean deleteOne(String questionId);

	public boolean upsertFuntion(String questionId);
}