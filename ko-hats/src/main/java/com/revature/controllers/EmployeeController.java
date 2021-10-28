package com.revature.controllers;

import java.util.Scanner;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;

public class EmployeeController {

	private EmployeeService us = new EmployeeService();
	
//	public void searchForEmployee() throws UserNotFoundException {
//		Employee e = us.getEmployeeById(0); 
//	}
	
	public void registerEmployee(Scanner scan) {
		System.out.println("Please enter a username:");
		String username = scan.nextLine();
		System.out.println("Please enter a password:");
		String password = scan.nextLine();
		System.out.println("Please enter your name: ");
		String name = scan.nextLine();
		
		Employee newEmployee = new Employee(0, name, username, password, null, null);
		
		// TODO: check whether an employee created or not (if the method works)
		us.addEmployee(newEmployee);
		
		System.out.println("Employee has been registered");
		
	}
	
	public void EmployeeLogin(Scanner scan) {
		System.out.println("Please enter a username:");
		String username = scan.nextLine();
		System.out.println("Please enter a password:");
		String password = scan.nextLine();
	}
}
