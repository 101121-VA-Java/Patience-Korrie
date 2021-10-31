package com.revature.controllers;

import java.util.Scanner;

import com.revature.exceptions.LoginException;
import com.revature.models.Employee;
import com.revature.models.Roles;
import com.revature.services.EmployeeService;
import com.revature.services.UsernameAlreadyExistsException;

public class EmployeeController {

	private EmployeeService es = new EmployeeService();

	
	public void registerEmployee(Scanner scan) {
		System.out.println("Please enter a username:");
		String username = scan.nextLine();
		System.out.println("Please enter a password:");
		String password = scan.nextLine();
		System.out.println("Please enter your name: ");
		String name = scan.nextLine();
		
		Employee newEmployee = new Employee(0,name,username,password,Roles.Empolyee,0);
		
		
		try {
			newEmployee = es.addEmployee(newEmployee);
			System.out.println("Welcome " + newEmployee.getName() + "!");
		} catch (UsernameAlreadyExistsException e) {
			System.out.println("Username is already in use.\nPlease try again.");
		}
		
		
	}
	
	public void EmployeeLogin(Scanner scan) {
		System.out.println("Please enter a username:");
		String username = scan.nextLine();
		System.out.println("Please enter a password:");
		String password = scan.nextLine();
		
		
		try {
			Employee login =  es.login(username, password);
			System.out.println("Welcome " + login.getName() + "!");
		} catch (LoginException l) {
			System.out.println("Username or password is invalid. Please try again.");
		}
		
		//use if statements to check if employee is in the list of employee
	}
}
