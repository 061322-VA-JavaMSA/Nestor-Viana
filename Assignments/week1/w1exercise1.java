package com.revature.scanner;

import java.util.Scanner;

public class w1exercise1 {

	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		menu();
		sc.close();
	}

	public static void menu() {
		
		int input;
		do {
			System.out.println("Please choose an option");
			System.out.println("1 Get a random number");
			System.out.println("2 Reverse a string");
			System.out.println("3 Exit program");
			input = sc.nextInt();
			sc.nextLine();
			
			if(input == 1) {
				int random = (int) (Math.random()*1000);
				System.out.println("Your number is " + random + ".");
				System.out.println();
				
			}
			if(input == 2) {
				System.out.println("Please input a phrase to reverse.");
				String phrase = sc.nextLine();
				StringBuffer revPhrase = new StringBuffer(phrase).reverse();
				System.out.println(revPhrase.toString());
				System.out.println();
				
			}
			
		}while(input != 3);
		
		System.out.println("Exiting program. Thanks.");
		
	}

}
