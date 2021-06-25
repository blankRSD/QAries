package com.teamone.webapp.services;

import com.teamone.postgres.contracts.IUserDAO;
import com.teamone.postgres.dao.UserDAO;
import com.teamone.postgres.entity.User;

public class LoginService {
	public boolean loginValidate(User userLogin) {
		
		IUserDAO dao = new UserDAO();
		User user = dao.fetchUser(userLogin.getEmail());
		return userLogin.getUsername().equals(user.getUsername()) && userLogin.getPassword().equals(user.getPassword()); 
	}

}
