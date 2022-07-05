package com.revature.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.revature.misc.Flavors;
import com.revature.misc.Items;
import com.revature.services.EmployeeService;

public class EmployeeServiceTests {
	
	@Test
	void addingConeItemShouldReturnItem(){
		Items item = new Items("cone","wafer cone",(float)5.10);
		assertEquals(item, EmployeeService.addItem(item));
	}
	
	@Test
	void addingAvocadoFlavorShouldReturnFlavor() {
		Flavors flavor = new Flavors("avocado");
		assertEquals(flavor, EmployeeService.addFlavor(flavor));
	}
	
	@Test
	void updatingMenuItem_Id2_With_CasteliaCone_ShouldReturnTrue() {
		Items item = new Items("castelia cone","ice cream cone that never melts",(float)10.00);
		assertEquals(true, EmployeeService.updateItem(item, 2));
	}
	
	@Test
	void removingItemWithId1ShouldReturnTrue() {
		assertEquals(true, EmployeeService.removeItemById(1));
	}
	
	@Test
	void removingFlavorWith_Id1_ShouldReturnTrue() {
		assertEquals(true, EmployeeService.removeFlavorById(1));
	}
	
	
	
}
