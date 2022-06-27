package com.revature;

import java.util.Arrays;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class Driver {
	
	static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		
		System.out.println("Welcome to RevatureRobins! \nWhat would you like to do today? (Enter the number of your option)" );
		System.out.println("1: View available menu options.");
		System.out.println("2: Log into your RevatureRobins account.");
		System.out.println("3: Create an account.");
		System.out.println("4: Exit shop.");
		
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
		//System.out.println(userInput);
		
		
		

		
		
		
		
		scan.close();
	}

}
