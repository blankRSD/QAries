package com.teamone.webapp.services;

import com.teamone.postgres.contracts.IUserDAO;
import com.teamone.postgres.dao.UserDAO;
import com.teamone.postgres.entity.User;

public class RegistrationService {
	
	private static IUserDAO dao = new UserDAO();
	
	private RegistrationService() {
	}
	
	public static boolean exists(User userBean) {
		if(dao.getByEmail(userBean.getEmail()) == null) {			
			return false;
		}

		return true;
	}
	
	public static boolean save(User userBean) {
		return dao.insert(userBean);
	}

}
