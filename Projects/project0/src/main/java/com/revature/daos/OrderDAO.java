package com.revature.daos;

import com.revature.models.Order;

public interface OrderDAO {
	
	public Order createOrder(Order order);
	public Order retrieveOrderById(int id);
	public Order retrieveOrderByUsername(String username);
	public boolean updateOrder(Order order, int id);
	public void deleteOrderById(int id);

}
