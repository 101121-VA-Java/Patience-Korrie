package com.revature;

import com.revature.exceptions.CalculatorException;

public class Calculator {

	/*
	 * Should be able to
	 * 	- add
	 * 	- subtract
	 * 	- multiply
	 * 	- divide
	 * 		- throw Calculator Exception (Runtime) when attempting to divide by 0
	 *	- isPrime: checks if a number is Prime
	 */
	
	public double add(double x, double y) {
		double sum = x+y;
		return sum;
	}
	
	public double subtract(double x, double y) {
		double sub = x-y;
		return sub;
	}
	
	public double multiply(double x, double y) {
		double mult = x*y;
		return mult;
	}
	
	public double divide(double x, double y) {
		double div = x/y;
		if(y == 0.0) {
			throw new CalculatorException();
		}
			return div;
		
	}
	
	public boolean isPrime(int i) {
		if(i%2 > 0) {
			System.out.println(i%2);	
			return true;
		}else if(i==2) {
		return true;
		}else {
			return false;
		}
	}
	
}
