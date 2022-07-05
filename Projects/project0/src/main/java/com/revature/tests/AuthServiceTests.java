package com.revature.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.revature.exceptions.LoginException;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.services.AuthService;

public class AuthServiceTests {

	AuthService as = new AuthService();
	
	@Test
	void jazz_jazz_ShouldLoginAsCustomer() throws LoginException {
		Customer customer = new Customer(7, "Jazmin","Zabala", "jazz","jazz");
		assertEquals(customer, as.loginAuth("jazz", "jazz"));
		
	}
	
	@Test
	void username_Nest_isAlreadyTaken() {
		String username = "Nest";
		assertEquals(true, AuthService.registerAuth(username));
	}
	
	@Test 
	void username_pianoMan_isNotTaken(){
		String username = "pianoMan";
		assertEquals(false, AuthService.registerAuth(username));
	}
	
	@Test
	void cturo_1234_ShouldLoginAsEmployee() throws LoginException {
		Employee employee = new Employee(5, "Camila", "Turo", "cturo","1234");
		assertEquals(employee, as.loginAuthEmpl("cturo", "1234"));
	}
	
}
