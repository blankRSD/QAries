package com.teamone.mongodb.dao;
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Filters.and;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.teamone.mongodb.entity.Question;
import com.teamone.mongodb.interfaces.IQuestionDOO;
import com.teamone.mongodb.util.MongoConn;


public class QuestionDOO implements IQuestionDOO {

	@Override
	public boolean insertOne(Question question) {
		try {
			MongoClient mc = MongoConn.mongoUtil();
			MongoDatabase questionTable = mc.getDatabase("question");
			ObjectId id1 = new ObjectId();
			question.setQuestionId(id1.toString());
			MongoCollection<Question> questionCollection = questionTable.getCollection("question", Question.class);
			Date dt = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String currentTime = sdf.format(dt);
			question.setModifiedAt(currentTime);
			questionCollection.insertOne(question);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean insertMany(List<Question> questionList) {
		try {
			MongoClient mc = MongoConn.mongoUtil();
			MongoDatabase questionTable = mc.getDatabase("question");
			MongoCollection<Question> questionCollection = questionTable.getCollection("question", Question.class);
			questionCollection.insertMany(questionList);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public Question getOneQuestionWithQuestionId(String id) {
		try {
			MongoClient mc = MongoConn.mongoUtil();
			MongoDatabase questionTable = mc.getDatabase("question");
			MongoCollection<Question> questionCollection = questionTable.getCollection("question", Question.class);
			Question question = questionCollection.find(eq("questionId", id)).first();
			return question;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Question getOneRecord(int votes) {
		try {
			MongoClient mc = MongoConn.mongoUtil();
			MongoDatabase questionTable = mc.getDatabase("question");
			MongoCollection<Question> questionCollection = questionTable.getCollection("question", Question.class);
			Question question = questionCollection.find(eq("votes", votes)).first();
			return question;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Question> getAllQuestions() {
		try {
			MongoClient mc = MongoConn.mongoUtil();
			MongoDatabase questionTable = mc.getDatabase("question");
			MongoCollection<Question> questionCollection = questionTable.getCollection("question", Question.class);
			FindIterable<Question> iterable = questionCollection.find();
			MongoCursor<Question> iterator = iterable.iterator();
			List<Question> questionListNew = new ArrayList<Question>();
			while (iterator.hasNext()) {
				questionListNew.add(iterator.next());
			}
			return questionListNew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Question> getQuestionsWithCondition(int votes, int limit) {
		try {
			MongoClient mc = MongoConn.mongoUtil();
			MongoDatabase questionTable = mc.getDatabase("question");
			MongoCollection<Question> questionCollection = questionTable.getCollection("question", Question.class);
			Bson condition = gte("votes", votes);
			List<Question> questionListNew = new ArrayList<Question>();
			MongoCursor<Question> iterator = questionCollection.find(condition).limit(limit).iterator();
			while (iterator.hasNext()) {
				questionListNew.add(iterator.next());
			}
			return questionListNew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateQuestion() {
		try {
			MongoClient mc = MongoConn.mongoUtil();
			MongoDatabase questionTable = mc.getDatabase("question");
			MongoCollection<Question> questionCollection = questionTable.getCollection("question", Question.class);
			Bson condition = and(eq("title", "hello there"), eq("userId", 3));
			questionCollection.updateMany(condition,
					Updates.set("title", "hello there beautiful"));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// delete one and mnay bach raha hai
	// update one many mei doubt hai
	// upsert implement karna hai
	// test cases likhne hain

	@Override
	public boolean deleteOne(String questionId) {
		try {
			MongoClient mc = MongoConn.mongoUtil();
			MongoDatabase questionTable = mc.getDatabase("question");
			MongoCollection<Question> questionCollection = questionTable.getCollection("question", Question.class);
			Bson condition = eq("questionId", questionId);
			DeleteResult deleteResult = questionCollection.deleteOne(condition);
			if (deleteResult.getDeletedCount() == 1) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean upsertFuntion(String questionId) {
		try {
			MongoClient mc = MongoConn.mongoUtil();
			MongoDatabase questionTable = mc.getDatabase("question");
			MongoCollection<Question> questionCollection = questionTable.getCollection("question", Question.class);
			Document d = new Document();
			Bson filter = eq("questionId", questionId);
			Bson updateOperation = Updates.set("title", "kya baat hai ");
			UpdateOptions options = new UpdateOptions().upsert(true);
			questionCollection.updateOne(filter, updateOperation, options);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}




}
