package com.teamone.postgres.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.teamone.postgres.contracts.IUserDAO;
import com.teamone.postgres.entity.User;
import com.teamone.postgres.util.JPAUtil;


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
	public User getById(int userId) {
		
		return entityManager.find(User.class, userId); 
		
	}
	
	@Override
	public User getByEmail(String email) {

		Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.email LIKE :email", User.class)
						.setParameter("email", email);
		
		try {
			return (User) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
