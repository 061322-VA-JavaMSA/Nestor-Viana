package com.revature.daos;

import com.revature.models.Customer;

public interface CustomerDAO {
	
	public Customer createCustomer(Customer customer);
	public Customer retrieveCustomerById(int id);
	public Customer retrieveCustomerByUsername(String username);
	public boolean updateCustomer(Customer customer, int id);
	public void deleteCustomer(int id); 
	

}
