package com.harashit.interfaces;


import java.util.List;


import com.harashit.entity.Question;



public interface IQuestionDOO {
	public boolean insertOne(Question question);
	public boolean insertMany(List<Question> questionList);

	public Question getOneRecord(int votes);

	public List<Question> getAllQuestions();

	public List<Question> getQuestionsWithCondition(int votes, int limit);

	public boolean updateQuestion();

	public boolean deleteOne(int questionId);

	public boolean upsertFuntion(int questionId);
}