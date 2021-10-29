package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.Employee;
import com.revature.models.Roles;
import com.revature.services.EmployeeService;
import com.revature.services.UsernameAlreadyExistsException;

public class EmployeeController {

	private EmployeeService us = new EmployeeService();

	
	public void registerEmployee(Scanner scan) throws UsernameAlreadyExistsException {
		System.out.println("Please enter a username:");
		String username = scan.nextLine();
		System.out.println("Please enter a password:");
		String password = scan.nextLine();
		System.out.println("Please enter your name: ");
		String name = scan.nextLine();
		
		Employee newEmployee = new Employee(0,name,username,password,Roles.Empolyee,0);
		
		// TODO: check whether an employee created or not (if the method works)
		us.addEmployee(newEmployee);
		
		System.out.println("Employee has been registered");
		System.out.println();
		
	}
	
//	public void EmployeeLogin(Scanner scan) {
//		System.out.println("Please enter a username:");
//		String username = scan.nextLine();
//		System.out.println("Please enter a password:");
//		String password = scan.nextLine();
//		
//		//use if statements to check if employee is in the list of employee
//	}
}
