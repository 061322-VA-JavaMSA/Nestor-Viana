package com.revature.calculator;

import com.revature.exceptions.DivideBy0Exception;
import com.revature.exceptions.NullArrayException;
import com.revature.exceptions.Number13Exception;

public class Calculator {
	
	public int add(int a, int b) throws Number13Exception {
		int result = a+b;
		if(result == 13) {
			throw new Number13Exception();
		}else {
			return result;
		}
	}
	
	public int subtract(int a, int b) {
		return a-b;
	}
	
	public int multiply(int a, int b) {
		return a*b;
	}
	
	public double divide(int a, int b) {
		if(b == 0) {
			throw new DivideBy0Exception();
		}else {
			return a/b;
		}
	}
	
	public int[] arrayAdd(int[] a, int[] b){
		if(a.length != b.length) {
			throw new NullArrayException();
		}else {
			int[] result = new int[a.length];
			for (int i = 0; i < a.length; i++) {
				result[i] = a[i] + b[i];
			}
			return result;
		}
			
			
	}
	
}
