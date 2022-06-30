package com.revature.misc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.services.CustomerService;
import com.revature.util.ConnectionUtil;

public class Items {
	
	private static Logger log = LogManager.getLogger(Items.class);
	
	private int id;
	private String name;
	private String description;
	private float price;
	
	public Items(int id, String description, float price) {
		super();
		this.id = id;
		this.description = description;
		this.price = price;
	}
	public Items() {
		// TODO Auto-generated constructor stub
	}
	
	public static void itemMenu() {
		List<Items> items = new ArrayList<>();
		Connection c;
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
		} catch (SQLException e) {
			log.error("SQL Exception was thrown. " + e.fillInStackTrace());
			e.printStackTrace();
		}
	
	}
	
	public static ArrayList<Items> itemMenuList() {
		List<Items> items = new ArrayList<>();
		Connection c;
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
		} catch (SQLException e) {
			log.error("SQL Exception was thrown. " + e.fillInStackTrace());
			e.printStackTrace();
		}
		return (ArrayList<Items>) items;
	
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return  id + ") " + name + "\t" + description + " | $" + String.format("%,.2f", price);
	}
	
	public String toString2() {
		return "[id=" + id + ", name=" + name + ", description=" + description + ", price=$" + String.format("%,.2f", price) + "]";
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
