package com.revature.services;

import java.util.List;

import com.revature.daoHibernate.UserHibernate;
import com.revature.daoImplement.UserDAOPostgres;
import com.revature.exceptions.UserNotCreatedException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.daos.userDAO;

public class UserService {
	
	private userDAO ud = new UserDAOPostgres();
	
	public User createUser(User u) throws UserNotCreatedException {
		// by default, created account will be basic Users
//		u.setRole(Role.BASIC_USER);
		
		User createdUser = ud.insertUser(u);
		if(createdUser.getId() == -1) {
			throw new UserNotCreatedException();
		}
		return createdUser;
	}
	
	public User getUserById(int id) throws UserNotFoundException {
		User u = ud.getUserById(id);
		if (u == null) {
			throw new UserNotFoundException();
		}
		return u;
	}	
	
	public List<User> getUsers() {
		List<User> users = ud.getUsers();
		return users;
	}
	
}
