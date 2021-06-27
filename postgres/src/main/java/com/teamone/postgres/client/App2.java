package com.teamone.postgres.client;

import com.teamone.postgres.entity.User;
import com.teamone.postgres.contracts.IUserDAO;
import com.teamone.postgres.dao.UserDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App2 {
	public static void main(String[] args) {
		
		IUserDAO dao = new UserDAO();
		
		User user = new User("raj", "anotherthing@nothing.com", "https://a.cmo");
		//log.info("{}", dao.insert(user));
		
		
		log.info("{}", dao.getByEmail("somethign@nothing.com"));
		
	}
}
