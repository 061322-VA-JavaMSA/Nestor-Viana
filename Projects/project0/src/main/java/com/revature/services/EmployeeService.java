package com.revature.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.misc.Flavors;
import com.revature.misc.Items;
import com.revature.models.Employee;
import com.revature.models.Order;
import com.revature.util.ConnectionUtil;

public class EmployeeService {
	
	private static Logger log = LogManager.getLogger(EmployeeService.class);
	static Scanner scan;
	
	public static void employeeLoginMenu(Employee employee) {
		
		scan = new Scanner(System.in);
		
		System.out.println("Welcome to your login menu, " + employee.getFirstname()+".\nWhat would you like to do? (Enter the number of your option)" );
		System.out.println("1) View current menu");
		System.out.println("2) View orders");
		System.out.println("3) Manage menu options");
		System.out.println("0) Log out");

		
		String userInput;
		List<String> inputs = Arrays.asList("1","2", "3","0");
		boolean b;
		do {
			userInput = scan.nextLine();
			b = inputs.contains(userInput);
			if(!b) {
				System.out.println("Please enter a valid option.");
			}
		} while (!b);
		
		switch(userInput) {
		case "0":
			log.info("Logging out of your account, " + employee.getUsername() + ". Thanks for checking out RevatureRobins. Have a great day!");
			break;
		
		case "1":
			
			Items.itemMenu();
			System.out.println();
			Flavors.flavorMenu();			
			System.out.println();
			employeeLoginMenu(employee);
			
			break;
			
		case "2":
			
			List<Order> orders = new ArrayList<>();
			String sql = "SELECT o.order_id, c.username, m.item_name, f1.flavor as flavor_1, f2.flavor as flavor_2, m.item_price "
					+ "FROM orders o "
					+ "JOIN customers c ON o.customer_id = c.id "
					+ "JOIN menu m ON o.menu_id = m.id "
					+ "JOIN flavors f1 ON o.flavor1_id = f1.id "
					+ "JOIN flavors f2 ON o.flavor2_id = f2.id "
					+ " ORDER BY o.order_id;";
			Order order = null;

			try (Connection c = ConnectionUtil.getConnectionFromEnv();) {
				ResultSet rs = c.createStatement().executeQuery(sql);

				while (rs.next()) {
					order = new Order();
					order.setOrderId(rs.getInt("order_id"));
					order.setCustomerUsername(rs.getString("username"));
					order.setItem_name(rs.getString("item_name"));
					order.setFlavor1(rs.getString("flavor_1"));
					order.setFlavor2(rs.getString("flavor_2"));
					order.setPrice(rs.getFloat("item_price"));
					
					orders.add(order);

				}
				for(Order order2: orders) {
					System.out.println(order2);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			employeeLoginMenu(employee);
			break;
			
		case "3":
			
			System.out.println("What would you like to do?");
			System.out.println("1) Add new cup item");
			System.out.println("2) Add new ice cream flavor");
			System.out.println("3) Update cup item");
			System.out.println("4) Update ice cream flavor");
			System.out.println("5) Delete cup item");
			System.out.println("6) Delete ice cream flavor");
			System.out.println("0) Go back");
			
			String userInput2;
			List<String> inputs2 = Arrays.asList("1","2", "3","4","5","6");
			boolean b2;
			do {
				userInput2 = scan.nextLine();
				b2 = inputs2.contains(userInput);
				if(!b) {
					System.out.println("Please enter a valid option.");
				}
			} while (!b2);
			
			switch (userInput2) {
			case "1":
				
				Items item = new Items();
				System.out.println("Enter new item name");
				item.setName(scan.nextLine());
				System.out.println("Enter new item description");
				item.setDescription(scan.nextLine());
				System.out.println("Enter new item price");
				item.setPrice(scan.nextFloat());
				
				addItem(item);
				
				log.info("New item " + item + " added successfully.");
				employeeLoginMenu(employee);
				
				break;
			case "2":
				
				Flavors flavor = new Flavors();
				System.out.println("Enter new flavor");
				flavor.setFlavor(scan.nextLine());
				
				addFlavor(flavor);
				
				log.info("New flavor " + flavor + " added successfully.");
				
				employeeLoginMenu(employee);
				
				break;
			case "3":
				
				System.out.println("Enter the id of the item to be updated");
				int updateId = Integer.parseInt(scan.nextLine());
				Items oldItem = Items.itemMenuList().get(updateId-1);
				System.out.println(oldItem);
						
				System.out.println("Enter the new fields of the item");
				Items item2 = new Items();
				System.out.println("Enter item name");
				item2.setName(scan.nextLine());
				System.out.println("Enter item description");
				item2.setDescription(scan.nextLine());
				System.out.println("Enter item price");
				item2.setPrice(scan.nextFloat());
				
				updateItem(item2, updateId);
				
				log.info("OLD ITEM: " + oldItem);
				log.info("NEW ITEM: " + item2);
				
				employeeLoginMenu(employee);
				break;
			case "4":
				
				System.out.println("Enter the id of the flavor to be updated");
				int updateId2 = Integer.parseInt(scan.nextLine());
				Flavors oldFlavor = Flavors.flavorMenuList().get(updateId2-1);
				System.out.println(oldFlavor);
						
				System.out.println("Enter the new flavor");
				Flavors flavor2 = new Flavors();
				flavor2.setFlavor(scan.nextLine());
				
				updateFlavor(flavor2, updateId2);
				
				log.info("OLD ITEM: " + oldFlavor);
				log.info("NEW ITEM: " + flavor2);
				
				employeeLoginMenu(employee);
				
				break;
			case "5":
				
				System.out.println("Enter the id of the item to be deleted");
				int deleteId = Integer.parseInt(scan.nextLine());
				Items deleteItem = Items.itemMenuList().get(deleteId-1);
				System.out.println("Item to be deleted confirmation: " + deleteItem);
				System.out.println("y OR n ?");
				String answer = scan.nextLine();
				if(answer.equals("y")) {
					removeItemById(deleteId);
					log.info("Item " + deleteItem + " DELETED.");
				}else {
					log.info("Item deletion CANCELLED.");
				}
				
				employeeLoginMenu(employee);
				
				break;
			case "6":
				
				System.out.println("Enter the id of the flavor to be deleted");
				int deleteId2 = Integer.parseInt(scan.nextLine());
				Flavors deleteFlavor = Flavors.flavorMenuList().get(deleteId2-1);
				System.out.println("Item to be deleted confirmation: " + deleteFlavor);
				System.out.println("y OR n ?");
				String answer2 = scan.nextLine();
				if(answer2.equals("y")) {
					removeItemById(deleteId2);
					log.info("Flavor " + deleteFlavor + " DELETED.");
				}else {
					log.info("Flavor deletion CANCELLED.");
				}
				
				employeeLoginMenu(employee);
				
				
				break;
			case "0":
				employeeLoginMenu(employee);
				break;
			
			}
		
		scan.close();
		}
	}
	
	public static Items addItem(Items item) {
		
		String sql = "INSERT INTO menu (item_name, item_description, item_price) values (?,?,?) returning id;";
		
		try (Connection c = ConnectionUtil.getConnectionFromEnv();) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, item.getName());
			ps.setString(2, item.getDescription());
			ps.setFloat(3, item.getPrice());
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				item.setId(rs.getInt("id"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return item;
		
		//create new Items object Items(name, descrp, price) -- this will be for cups
		//create new Flavor object Flavors(flavor) -- this will be for new flavors
		
	}
	
	public static Flavors addFlavor(Flavors flavor) {
		
		String sql = "INSERT INTO flavors (flavor) values (?) returning id;";
		
		try (Connection c = ConnectionUtil.getConnectionFromEnv();) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, flavor.getFlavor());
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				flavor.setId(rs.getInt("id"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flavor;
		
	}
	
	//needs testing
	public static boolean removeItemById(int id) {
		
		String sql = "DELETE FROM menu WHERE id = ?;";
		int rowsChanged = -1;
		
		try (Connection c = ConnectionUtil.getConnectionFromEnv();) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);
			
			rowsChanged = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(rowsChanged < 1) {
			return false;
		}
		return true;
		
	}
	
	public static boolean removeFlavorById(int id) {
		
		String sql = "DELETE FROM flavors WHERE id = ?;";
		int rowsChanged = -1;
		
		try (Connection c = ConnectionUtil.getConnectionFromEnv();) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);
			
			rowsChanged = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(rowsChanged < 1) {
			return false;
		}
		return true;
		
	}
	
	public static boolean removeFlavorByName(String flavor) {
		
		String sql = "DELETE FROM menu WHERE flavor = ?;";
		int rowsChanged = -1;
		
		try (Connection c = ConnectionUtil.getConnectionFromEnv();) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, flavor);
			
			rowsChanged = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(rowsChanged < 1) {
			return false;
		}
		return true;
		
	}
	
	public static boolean updateItem(Items item, int id) {
		
		String sql = "UPDATE menu SET item_name = ?, item_description = ?, item_price = ? WHERE id = ?;";
		int rowsChanged = -1;
		
		try (Connection c = ConnectionUtil.getConnectionFromEnv();) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, item.getName());
			ps.setString(2, item.getDescription());
			ps.setFloat(3, item.getPrice());
			ps.setInt(4, id);
			
			rowsChanged = ps.executeUpdate();
			
			item.setId(id);  //check if it needs this

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(rowsChanged < 1) {
			return false;
		}
		return true;
		
	}
	
	public static boolean updateFlavor(Flavors newFlavor, int oldFlavor) {
		
		String sql = "UPDATE flavors SET flavor = ? WHERE id = ?;";
		int rowsChanged = -1;
		
		try (Connection c = ConnectionUtil.getConnectionFromEnv();) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, newFlavor.getFlavor());
			ps.setInt(2, oldFlavor);
			
			rowsChanged = ps.executeUpdate();
			
			newFlavor.setId(oldFlavor);  

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(rowsChanged < 1) {
			return false;
		}
		return true;
		
	}
	

}
