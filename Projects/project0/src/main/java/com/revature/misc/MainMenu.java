package com.revature.misc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.exceptions.LoginException;
import com.revature.models.Customer;
import com.revature.services.AuthService;
import com.revature.services.CustomerService;
import com.revature.util.ConnectionUtil;

public class MainMenu {
	
	private static Logger log = LogManager.getLogger(MainMenu.class);
	static Scanner scan = new Scanner(System.in);
	static Connection c;
	
	public static void mainMenu() {
		
		AuthService as = new AuthService();
		
		System.out.println("Welcome to RevatureRobins! \nWhat would you like to do today? (Enter the number of your option)" );
		System.out.println("1) View available menu options.");
		System.out.println("2) Log into your RevatureRobins account.");
		System.out.println("3) Create an account.");
		System.out.println("4) Exit shop.");
		
		String userInput;
		List<String> inputs = Arrays.asList("1","2", "3", "4");
		boolean b;
		do {
			userInput = scan.nextLine();
			b = inputs.contains(userInput);
			if(!b) {
				System.out.println("Please enter a valid option.");
			}
		} while (!b);
		
		switch(userInput) {
		case "1":
			
			Items.itemMenu();
			System.out.println();
			Flavors.flavorMenu();			
			System.out.println();
			System.out.println("Please login into your RevatureRobins account before ordering.");
			break;
			
		case "2":
			
			System.out.println("Please enter a username.");
			String username = scan.nextLine();
			System.out.println("Please enter a password.");
			String password = scan.nextLine();
			
			try {
				Customer customer = as.loginAuth(username, password);
				if(customer != null) {
					System.out.println();
					log.info("Login successful, user: " + customer.getUsername());
					CustomerService.customerLoginMenu(customer);
					
				}
			} catch (LoginException e) {
				System.out.println("Invalid credentials.");
				log.error("Login exception was thrown. " + e.fillInStackTrace());
				e.printStackTrace();
			}
			
			break;
		case "3":
			
			CustomerService.create();
	
			break;
		case "4":
				System.out.println("Thanks for checking out RevatureRobins. Have a great day!");
			
		}
		scan.close();
			
	}
	
	

}
