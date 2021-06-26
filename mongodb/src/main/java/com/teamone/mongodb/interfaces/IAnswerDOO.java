package com.teamone.mongodb.interfaces;


import java.util.List;

import com.teamone.mongodb.entity.Answer;




public interface IAnswerDOO {
	public boolean insertOne(Answer answer);

	public boolean insertMany(List<Answer> answerList);

	public Answer getOneRecord(int votes);

	public List<Answer> getAllAnswers();

	public List<Answer> getAnswersWithCondition(int votes, int limit);

	public boolean updateAnswer();

	public boolean deleteOne(int answerId);

	public boolean upsertFuntion(int answerId);
	
	public List<Answer> getAnswerWithQid(int qid);
}