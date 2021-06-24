package com.teamone.webapp.services;

import com.teamone.postgres.contracts.IUserDAO;
import com.teamone.postgres.dao.UserDAO;
import com.teamone.postgres.entity.User;

public class LoginService {
	public boolean loginValidate(User login) {
		
		IUserDAO dao = new UserDAO();
		User user = dao.getOne(login.getUserId());
		return login.getUsername().equals(user.getUsername()) && login.getPassword().equals(user.getPassword()); 
	}

}
