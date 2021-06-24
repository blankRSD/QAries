package com.teamone.mongodb.dao;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import org.bson.conversions.Bson;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import com.teamone.mongodb.contracts.IQuestionDao;
import com.teamone.mongodb.entity.Question;
import com.teamone.mongodb.util.MongoUtil;

public class QuestionDAO implements IQuestionDao{
	
	MongoCollection<Question> questionCollection;
	
	public QuestionDAO() {
//		MongoClient mc = MongoUtil.mongoUtil();
//		MongoDatabase navdb = mc.getDatabase("navdb");
//		questionCollection = navdb.getCollection("emp", Question.class);
		
		ConnectionString connString = new ConnectionString(
			    "mongodb+srv://admin:admin@cluster0.ovmps.mongodb.net/myFirstDatabase?retryWrites=true&w=majority"
			);
		MongoClientSettings settings = MongoClientSettings.builder()
			    .applyConnectionString(connString)
			    .retryWrites(true)
			    .build();
		MongoClient mongoClient = MongoClients.create(settings);
		
		MongoDatabase database = mongoClient.getDatabase("question");
		questionCollection = database.getCollection("question", Question.class);
	}

	public Question get(int questionId) {
		return (Question) questionCollection.find(eq("questionId", questionId)).first();
	}

	public List<Question> getAll() {
		return questionCollection.find().into(new ArrayList<Question>());
	}

	public void insertOne(Question question) {
		questionCollection.insertOne(question);
	}

	public void insertMany(List<Question> questions) {
		questionCollection.insertMany(questions);
	}

	public void update(Question question, String field, String newValueForField) {
		UpdateResult res = questionCollection.updateOne(eq("questionId", question.getQuestionId()), Updates.set(field, newValueForField));
	}

	public boolean delete(Question question) {
		return questionCollection.deleteOne(eq("questionId", question.getQuestionId())).getDeletedCount() > 0;
	}
	
	public long deleteMany(Bson filters) {
		return questionCollection.deleteMany(filters).getDeletedCount();
	}
	
	public MongoCollection<Question> getQuestionCollection() {
		return questionCollection;
	}


}
