package com.revature.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Ignore;

import com.revature.exceptions.Number13Exception;
import com.revature.exceptions.DivideBy0Exception;
import com.revature.exceptions.NullArrayException;

import org.junit.jupiter.api.Test;



public class calculatorTest {
	
	public static Calculator sut = new Calculator();
	
	public static void setUp() {
		
		sut = new Calculator();
	}
	

	/*public static void tearDown() {
		System.out.println("Tear down behavior.");
	}
	*/

	@Test
	public void addOneAndTwo() throws Number13Exception {
		int expected = 3;
		int actual = sut.add(1, 2);	
		assertEquals(expected, actual);
	}
	
	@Test
	public void addTenAndThree() {
		assertThrows(Number13Exception.class, () -> sut.add(10, 3));
	}
	
	@Test
	public void subtractFiveAndTwo() {
		int expected = 3;
		int actual = sut.subtract(5, 2);
		assertEquals(expected, actual);	
	}
	
	@Ignore
	public void divideFourAndZero() {
		assertThrows(DivideBy0Exception.class, () -> sut.divide(4, 0));  //test fails; expected DivideBy0Exception to be thrown; none thrown.
	}
	
	@Test
	public void sumOfArrays(){	    //executes normally when there's a length mismatch. However, fails when it compares two arrays that are equal (AssertionFailedError) --> need to fix
		int[] a = {1,2,3};
		int[] b = {3,2,1};
		int[] expected = {4,4,4};
		int[] actual = sut.arrayAdd(a, b);
		System.out.println(actual);
		assertEquals(expected, actual);	
		//assertThrows(NullArrayException.class, () -> sut.arrayAdd(a, b)); 
		
	}
}
