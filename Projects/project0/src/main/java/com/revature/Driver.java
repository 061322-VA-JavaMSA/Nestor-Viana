package com.revature;

import java.util.Arrays;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.misc.MainMenu;

public class Driver {
	
	private static Logger log = LogManager.getLogger(Driver.class);
	
	static Scanner scan;

	public static void main(String[] args) {

		MainMenu.mainMenu();	
		
	
	}
}
