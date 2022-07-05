package com.revature.misc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.util.ConnectionUtil;

public class Flavors {
	
	private static Logger log = LogManager.getLogger(Flavors.class);

	private int id;
	private String flavor;
	
	public Flavors() {
		super();
	}
	
	public Flavors(String flavor) {
		super();
		this.flavor = flavor;
	}
	
	public static void flavorMenu() {
		List<Flavors> flavors = new ArrayList<>();
		Connection c;
		System.out.println("Here are the available flavors:");
		String sql2 = "SELECT * FROM flavors ORDER BY id;";
		try {
			c = ConnectionUtil.getConnectionFromEnv();
		
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
		
		}catch (SQLException e) {
			log.error("SQL Exception was thrown. " + e.fillInStackTrace());
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Flavors> flavorMenuList() {
		List<Flavors> flavors = new ArrayList<>();
		Connection c;
//		System.out.println("Here are the available options:");
		String sql = "SELECT * FROM flavors ORDER BY id;";
		try {
			c = ConnectionUtil.getConnectionFromEnv();
			ResultSet rs = c.createStatement().executeQuery(sql);
			while(rs.next()) {
				Flavors flavor = new Flavors();
				flavor.setId(rs.getInt("id"));
				flavor.setFlavor(rs.getString("flavor"));
					
				flavors.add(flavor);
				
			}
			
		} catch (SQLException e) {
			log.error("SQL Exception was thrown. " + e.fillInStackTrace());
			e.printStackTrace();
		}
		return (ArrayList<Flavors>) flavors;
	
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFlavor() {
		return flavor;
	}
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}
	@Override
	public String toString() {
		return id + ") " + flavor;
	}
	
	
	
}
