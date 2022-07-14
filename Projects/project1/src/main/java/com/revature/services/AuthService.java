package com.revature.services;

import com.revature.daoImplement.UserDAOPostgres;
import com.revature.daos.userDAO;
import com.revature.exceptions.LoginException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

public class AuthService {
	
	private userDAO ud = new UserDAOPostgres();

	public User login(String username, String password) throws UserNotFoundException, LoginException {
		
		// principal refers to "currently logged in user"
		User principal = ud.getUserByUsername(username);
		
		if(principal == null) {
			throw new UserNotFoundException();
		}
		
		if(!principal.getPassword().equals(password)){
			throw new LoginException();
		}
		
		return principal;
	}

}
