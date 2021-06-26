package com.teamone.webapp.services;

import com.teamone.postgres.contracts.IUserDAO;
import com.teamone.postgres.dao.UserDAO;
import com.teamone.postgres.entity.User;

public class LoginService {
	public boolean validate(User userLogin) {
		
		IUserDAO dao = new UserDAO();
		User user = dao.getByEmail(userLogin.getEmail());
		return userLogin.getEmail().equals(user.getEmail()) && userLogin.getPassword().equals(user.getPassword()); 
		
	}

}
