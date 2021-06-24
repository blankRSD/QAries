package com.naveen.sql.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import com.teamone.postgres.entity.User;
import com.teamone.postgres.contracts.IUserDAO;
import com.teamone.postgres.dao.UserDAO;
import com.teamone.postgres.util.JPAUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App2 {
	public static void main(String[] args) {
		IUserDAO dao = new UserDAO();
		User user = new User(1, "raj", "somethign@nothing.com","pass", "https://a.cmo", "https://a.cmo", "https://a.cmo");
		log.info("{}", dao.insert(user));
		
	}
}
