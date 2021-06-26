package com.teamone.postgres.client;

import com.teamone.postgres.entity.User;
import com.teamone.postgres.contracts.IUserDAO;
import com.teamone.postgres.dao.UserDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App2 {
	public static void main(String[] args) {
		
		IUserDAO dao = new UserDAO();
		/*
		User user = new User(1, "raj", "somethign@nothing.com","pass", "https://a.cmo", "https://a.cmo", "https://a.cmo");
		log.info("{}", dao.insert(user));
		
		*/
		log.info("{}", dao.fetchUser("no1@some1.com"));
		
	}
}
