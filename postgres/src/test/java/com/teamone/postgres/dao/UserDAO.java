package com.teamone.postgres.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.teamone.postgres.contracts.IUserDAO;
import com.teamone.postgres.entity.User;
import com.teamone.postgres.util.JPAUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserDAO implements IUserDAO {
	
	EntityManager entityManager;
	
	public UserDAO() {
		entityManager = JPAUtil.getEntityManager(); 
	}

	@Override
	public boolean insert(User user) {
		try {
			entityManager.getTransaction().begin(); 
			entityManager.persist(user);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User getOne(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int userId) {
		// TODO Auto-generated method stub

	}

}
