package com.teamone.mongodb.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.conversions.Bson;

import static com.mongodb.client.model.Filters.eq;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import com.teamone.mongodb.contracts.IUserDao;
import com.teamone.mongodb.entity.User;
import com.teamone.mongodb.util.MongoUtil;

public class UserDAO implements IUserDao {
	
	MongoCollection<User> employeeCollection;
	
	public UserDAO() {
		MongoClient mc = MongoUtil.mongoUtil();
		MongoDatabase navdb = mc.getDatabase("navdb");
		employeeCollection = navdb.getCollection("emp", User.class);
	}

	public User get(int id) {
		return (User) employeeCollection.find(eq("empId", id)).first();
	}

	public List<User> getAll() {
		return employeeCollection.find().into(new ArrayList<User>());
	}

	public boolean insertOne(User emp) {
		try {
			employeeCollection.insertOne(emp);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean insertMany(List<User> emps) {
		try {
			employeeCollection.insertMany(emps);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(User emp, String field, String newValueForField) {
		UpdateResult res = employeeCollection.updateOne(eq("empId", emp.getEmpId()), Updates.set(field, newValueForField));
		return true;
	}

	public boolean delete(User emp) {
		return employeeCollection.deleteOne(eq("empId", emp.getEmpId())).getDeletedCount() > 0;
	}
	
	public long deleteMany(Bson filters) {
		  return employeeCollection.deleteMany(filters).getDeletedCount();
	}
	
	public MongoCollection<User> getEmployeeCollection(){
		return employeeCollection;
	}

}
