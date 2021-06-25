package com.harashit.dao;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Filters.and;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.harashit.entity.Answer;
import com.harashit.interfaces.IAnswerDOO;
import com.harashit.util.MongoConn;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;


public class AnswerDOO implements IAnswerDOO {

	@Override
	public boolean insertOne(Answer Answer) {
		try {
			MongoClient mc = MongoConn.mongoUtil();
			MongoDatabase AnswerTable = mc.getDatabase("question");
			MongoCollection<Answer> AnswerCollection = AnswerTable.getCollection("answer", Answer.class);
			Date dt = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String currentTime = sdf.format(dt);
			Answer.setModifiedAt(currentTime);
			AnswerCollection.insertOne(Answer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean insertMany(List<Answer> AnswerList) {
		try {
			MongoClient mc = MongoConn.mongoUtil();
			MongoDatabase AnswerTable = mc.getDatabase("question");
			MongoCollection<Answer> AnswerCollection = AnswerTable.getCollection("answer", Answer.class);
			AnswerCollection.insertMany(AnswerList);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Answer getOneRecord(int votes) {
		try {
			MongoClient mc = MongoConn.mongoUtil();
			MongoDatabase AnswerTable = mc.getDatabase("question");
			MongoCollection<Answer> AnswerCollection = AnswerTable.getCollection("answer", Answer.class);
			Answer Answer = AnswerCollection.find(eq("votes", votes)).first();
			return Answer;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Answer> getAllAnswers() {
		try {
			MongoClient mc = MongoConn.mongoUtil();
			MongoDatabase AnswerTable = mc.getDatabase("question");
			MongoCollection<Answer> AnswerCollection = AnswerTable.getCollection("answer", Answer.class);
			FindIterable<Answer> iterable = AnswerCollection.find();
			MongoCursor<Answer> iterator = iterable.iterator();
			List<Answer> AnswerListNew = new ArrayList<Answer>();
			while (iterator.hasNext()) {
				AnswerListNew.add(iterator.next());
			}
			return AnswerListNew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Answer> getAnswersWithCondition(int votes, int limit) {
		try {
			MongoClient mc = MongoConn.mongoUtil();
			MongoDatabase AnswerTable = mc.getDatabase("question");
			MongoCollection<Answer> AnswerCollection = AnswerTable.getCollection("answer", Answer.class);
			Bson condition = gte("votes", votes);
			List<Answer> AnswerListNew = new ArrayList<Answer>();
			MongoCursor<Answer> iterator = AnswerCollection.find(condition).limit(limit).iterator();
			while (iterator.hasNext()) {
				AnswerListNew.add(iterator.next());
			}
			return AnswerListNew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateAnswer() {
		try {
			MongoClient mc = MongoConn.mongoUtil();
			MongoDatabase AnswerTable = mc.getDatabase("question");
			MongoCollection<Answer> AnswerCollection = AnswerTable.getCollection("answer", Answer.class);
			Bson condition = and(eq("title", "hello there"), eq("userId", 3));
			AnswerCollection.updateMany(
					condition,
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
	public boolean deleteOne(int AnswerId) {
		try {
			MongoClient mc = MongoConn.mongoUtil();
			MongoDatabase AnswerTable = mc.getDatabase("question");
			MongoCollection<Answer> AnswerCollection = AnswerTable.getCollection("answer", Answer.class);
			Bson condition = eq("AnswerId", AnswerId);
			DeleteResult deleteResult = AnswerCollection.deleteOne(condition);
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
	public boolean upsertFuntion(int AnswerId) {
		try {
			MongoClient mc = MongoConn.mongoUtil();
			MongoDatabase AnswerTable = mc.getDatabase("question");
			MongoCollection<Answer> AnswerCollection = AnswerTable.getCollection("answer", Answer.class);
			Document d = new Document();
			Bson filter = eq("AnswerId", AnswerId);
			Bson updateOperation = Updates.set("title", "kya baat hai ");
			UpdateOptions options = new UpdateOptions().upsert(true);
			AnswerCollection.updateOne(filter, updateOperation, options);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}




}
