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

import com.revature.daoimplemt.CustomerDAOImpl;
import com.revature.daoimplemt.OrderDAOImpl;
import com.revature.daos.CustomerDAO;
import com.revature.daos.OrderDAO;
import com.revature.misc.Flavors;
import com.revature.misc.Items;
import com.revature.misc.MainMenu;
import com.revature.models.Customer;
import com.revature.models.Order;
import com.revature.util.ConnectionUtil;

public class CustomerService {
	
	private static Logger log = LogManager.getLogger(CustomerService.class);
	static Scanner scan;
	
	public static void create(){
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter your first name.");
		String firstname = scan.nextLine();
		System.out.println("Please enter your last name.");
		String lastname = scan.nextLine();
		
		System.out.println("Please enter a username.");
		String username = scan.nextLine();
		if(AuthService.registerAuth(username)) {
			create();
//			System.exit(0);	
		}else {
			System.out.println("Username available.");
		}
		System.out.println("Please enter a password.");
		String password = scan.nextLine();
		
		Customer customer = new Customer(firstname, lastname, username, password);
		CustomerDAO customerDao = new CustomerDAOImpl();
		
		customer = customerDao.createCustomer(customer);
		log.info("Account" + customer.toString() +  " successfully created!");
		
		scan.close();
		
	}
	
	public static void customerLoginMenu(Customer customer) {
		scan = new Scanner(System.in);
		
		System.out.println("Welcome to your login menu, " + customer.getFirstname()+".\nWhat would you like to do? (Enter the number of your option)" );
		System.out.println("1) View available menu options");
		System.out.println("2) Purchase an item"); //This works as "making offer for an item".
		System.out.println("3) View my orders");
		System.out.println("4) Log out");
		
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
			customerLoginMenu(customer);
			
			break;
		case "2":
			
			System.out.println("What type of ice cream would you like to buy?");
			Items.itemMenu();
			String userInput2;
			List<String> inputs2 = Arrays.asList("1","2","3");
//			System.out.println(inputs2.size());
			boolean b2;
			do {
				userInput2 = scan.nextLine();
				b2 = inputs2.contains(userInput2);
				if(!b2) {
					System.out.println("Please enter a valid option.");
				}
			} while (!b2);
			
			List<Items> items = Items.itemMenuList();
			
			System.out.println("You want to buy a " + items.get(Integer.parseInt(userInput2)-1).toString2());
			System.out.println("With what two flavors? (Enter flavor 1)");
			int flavor1 = scan.nextInt();
			System.out.println("(enter flavor 2)");
			int flavor2 = scan.nextInt();
			
			Order order = new Order(customer.getId(), Integer.parseInt(userInput2), flavor1, flavor2);
			OrderDAO OrderDao = new OrderDAOImpl();
			
			order = OrderDao.createOrder(order);
			log.info( order.toString2() +  " successfully queued!");
			System.out.println();
			
			customerLoginMenu(customer);
			

			break;
		case "3":
			
			List<Order> orders = new ArrayList<>();
			String sql = "SELECT o.order_id, c.username, m.item_name, f1.flavor as flavor_1, f2.flavor as flavor_2, m.item_price "
					+ "FROM orders o "
					+ "JOIN customers c ON o.customer_id = c.id "
					+ "JOIN menu m ON o.menu_id = m.id "
					+ "JOIN flavors f1 ON o.flavor1_id = f1.id "
					+ "JOIN flavors f2 ON o.flavor2_id = f2.id "
					+ "WHERE c.id  = " + customer.getId() + " ORDER BY o.order_id;";
			//Order order = null;

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
			customerLoginMenu(customer);

			break;
		case "4":
			
			log.info("Logging out of your account, " + customer.getUsername() + ". Thanks for checking out RevatureRobins. Have a great day!");

			break;
		
		}
		scan.close();
		
	}
	
}
