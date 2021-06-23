package com.teamone.mongodb.contracts;

import static com.mongodb.client.model.Filters.eq;

import java.util.List;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import com.teamone.mongodb.entity.User;

public interface IUserDao {

	public User get(int id);
	
	public List<User> getAll();
	
	public boolean insertOne(User emp);
	
	public boolean insertMany(List<User> emps);
	
	public boolean update(User emp, String field, String newValueForField);
	
	public boolean delete(User emp);
	
	public MongoCollection<User> getEmployeeCollection();
}
