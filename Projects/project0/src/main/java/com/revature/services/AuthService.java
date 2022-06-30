package com.revature.services;

import com.revature.daoimplemt.CustomerDAOImpl;
import com.revature.daos.CustomerDAO;
import com.revature.exceptions.LoginException;
import com.revature.models.Customer;

public class AuthService {
	
	private static CustomerDAO customerDao = new CustomerDAOImpl();
	
	public Customer loginAuth(String username, String password) throws LoginException {
		
		// if username/password passed are null, throws an exception
		if (username == null || password == null) {
			throw new LoginException();
		}

		Customer customer = customerDao.retrieveCustomerByUsername(username);
		// if no user of that name has been retrieved/if pass don't match, throw an
		// exception
		if (customer == null || !customer.getPassword().equals(password)) {
			throw new LoginException();
			
		}
		return customer;
	}
	
	//If username hasn't been registered, this method returns FALSE; If username already registered, return TRUE; If no username is entered, return RegisterException
	public static boolean registerAuth(String username){
		if (username == null) {
			System.out.println("Username cannot be empty");
			return true;
		}
		Customer customer = customerDao.retrieveCustomerByUsername(username);
		if (customer != null){
			System.out.println("Username already taken. Please create another account.");
			System.out.println();
			return true;
		}
		
		return false;
	}

}
