package com.teamone.mongodb.contracts;

import java.util.List;

import com.mongodb.client.MongoCollection;
import com.teamone.mongodb.entity.Question;

public interface IQuestionDao {
	
	public Question get(int id);
	
	public List<Question> getAll();
	
	public void insertOne(Question question);
	
	public void insertMany(List<Question> questions);
	
	public void update(Question question, String field, String newValueForField);
	
	public boolean delete(Question question);
	
	public MongoCollection<Question> getQuestionCollection();
	
}
