package com.revature.misc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.revature.util.ConnectionUtil;

public class Menu {
	
	static Scanner scan = new Scanner(System.in);
	static Connection c;
	
	public static String menu() {
		
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
		
		scan.close();
		
		List<Items> items = new ArrayList<>();
		List<Flavors> flavors = new ArrayList<>();
		
		//return userInput;
		switch(userInput) {
		case "1":
			System.out.println("Here are the available options:");
			String sql = "SELECT * FROM menu;";
			try {
				c = ConnectionUtil.getConnectionFromEnv();
				ResultSet rs = c.createStatement().executeQuery(sql);
				while(rs.next()) {
					Items item = new Items();
					item.setId(rs.getInt("id"));
					item.setName(rs.getString("item_name"));
					item.setDescription(rs.getString("item_description"));
					item.setPrice(rs.getFloat("item_price"));
					
					items.add(item);
					
				}
				for(Items item : items) {
					System.out.println(item);
				}
				
				System.out.println();
				System.out.println("Here are the available flavors:");
				String sql2 = "SELECT * FROM flavors;";
				
				ResultSet rs2 = c.createStatement().executeQuery(sql2);
				while(rs2.next()) {
					Flavors flavor = new Flavors();
					flavor.setId(rs2.getInt("id"));
					flavor.setFlavor(rs2.getString("flavor"));
						
					flavors.add(flavor);
						
					}
					for(Flavors flavor : flavors) {
						System.out.println(flavor);
					}
				
				System.out.println("Please login into your RevatureRobins account before ordering.");
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//return null;
			
		case "2":
			
			break;
		case "3":
			
			
	
			break;
		case "4":
				System.out.println("Thanks for checking out RevatureRobins. Have a great day!");
				return userInput;
			
		}
		return null;
			
	}
	
	

}
