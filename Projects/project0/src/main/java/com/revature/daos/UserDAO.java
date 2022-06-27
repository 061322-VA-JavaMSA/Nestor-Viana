package com.revature.daos;

import com.revature.models.User;

public interface UserDAO {
	
	User createUser(User u);
	User retrieveUserById(int id);
	User retrieveUserByUsername(String username);
	User retrieveUserByName(String firstname, String lastname);
	Boolean updateUser(User u);
	Boolean deleteUserByUsername(String username);
	Boolean deleteUserById(int id);
	

}
