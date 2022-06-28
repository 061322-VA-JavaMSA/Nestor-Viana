package com.revature.services;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.revature.daoimplemt.CustomerDAOImpl;
import com.revature.daos.CustomerDAO;
import com.revature.models.Customer;

public class CustomerService {
	
	public static Customer create() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter your first name.");
		String firstname = scan.nextLine();
		System.out.println("Please enter your last name");
		String lastname = scan.nextLine();
		
//		String userInput;
//		List<String> inputs = Arrays.asList("1","2", "3", "4");
//		boolean b;
//		do {
//			
//			userInput = scan.nextLine();
//			b = inputs.contains(userInput);
//			if(!b) {
//				System.out.println("Please enter a valid option.");
//			}
//		} while (!b);
		
		
		
		String username = scan.nextLine();
		String password = scan.nextLine();
		
		Customer customer = new Customer(firstname, lastname, username, password);
		CustomerDAO customerDao = new CustomerDAOImpl();
		
		customer = CustomerDAO.createCustomer(customer);
		
		
		
		
	}

}
