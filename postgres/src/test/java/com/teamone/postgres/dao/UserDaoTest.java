package com.teamone.postgres.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.teamone.postgres.contracts.IUserDAO;
import com.teamone.postgres.entity.User;

public class UserDaoTest {
	
	IUserDAO dao;

	@Before
	public void setUp() {
		dao = new UserDAO();
	}
	
	@After
	public void setDown() {
	}
	
	@Test
	public void insertTest() {
		boolean res = dao.insert(new User("someone", "some@not.com", "pass1234"));
		assertTrue(res);		
	}

}
