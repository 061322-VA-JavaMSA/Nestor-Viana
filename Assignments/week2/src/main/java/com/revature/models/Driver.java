package com.revature.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String url = "jdbc:[driver]://[url]:[port]/[db-name]";
		String url = "jdbc:postgresql://database-2.cdzhadc85fxj.us-east-1.rds.amazonaws.com:5432/postgres";
		String username = "nestor1124";
		String password = "112401Nv!";
		
		try {
			Connection c = DriverManager.getConnection(url, username, password);
			System.out.println(c.getMetaData().getDriverName());
			//Statement s = c.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
