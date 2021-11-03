package com.revature.controllers;

import java.util.Scanner;

import com.revature.exceptions.LoginException;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Roles;
import com.revature.services.CustomerService;
import com.revature.services.EmployeeService;
import com.revature.services.UsernameAlreadyExistsException;

public class EntryController {

	private CustomerService cs = new CustomerService();
	private EmployeeService es = new EmployeeService();
	int role;
	
	public void register(Scanner scan) {
		System.out.println("Please enter a username:");
		String username = scan.nextLine();
		System.out.println("Please enter a password:");
		String password = scan.nextLine();
		System.out.println("Please enter your name: ");
		String name = scan.nextLine();
		System.out.println("Customer 1 or Employee 2: ");
		 role = Integer.parseInt(scan.nextLine());
		if (role == 1) {
			Customer newCustomer = new Customer(0,name, username,password,Roles.Customer);
			
			try {
				newCustomer = cs.addCustomer(newCustomer);
				System.out.println("Welcome " + newCustomer.getName() + "!");
			} catch (UsernameAlreadyExistsException e) {
				System.out.println("Username is already in use.\nPlease try again.");
			}
			
		}else if(role == 2) {
			
			Employee newEmployee = new Employee(0,name,username,password,Roles.Empolyee,0);
			
			 try {
					newEmployee = es.addEmployee(newEmployee);
					System.out.println("Welcome " + newEmployee.getName() + "!");
				} catch (UsernameAlreadyExistsException e) {
					System.out.println("Username is already in use.\nPlease try again.");
				}
			 }
		}
	
	public void Login(Scanner scan) {
		System.out.println("Please enter a username:");
		String username = scan.nextLine();
		System.out.println("Please enter a password:");
		String password = scan.nextLine();
		
		if (role == 1) {
			
			try {
				Customer login =  cs.login(username, password);
				System.out.println("Welcome " + login.getName() + "!");
			} catch (LoginException l) {
				System.out.println("Username or password is invalid. Please try again.");
			}
			}else if (role == 2){
				
				try {
					Employee login =  es.login(username, password);
					System.out.println("Welcome " + login.getName() + "!");
				} catch (LoginException l) {
					System.out.println("Username or password is invalid. Please try again.");
				}
			}
	}
}
