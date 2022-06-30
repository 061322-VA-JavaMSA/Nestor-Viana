package com.revature.daos;

import com.revature.models.Employee;

public interface EmployeeDAO {
	
	public Employee createEmployee(Employee employee);
	public Employee retrieveEmployeeById(int id);
	public Employee retrieveEmployeeByUsername(String username);
	public boolean updateEmployee(Employee employee, int id);
	public void deleteEmployee(int id); 

}
