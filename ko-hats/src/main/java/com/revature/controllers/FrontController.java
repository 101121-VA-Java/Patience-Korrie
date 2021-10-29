package com.revature.controllers;

import java.util.Scanner;

import com.revature.services.UsernameAlreadyExistsException;

public class FrontController {
	
	private Scanner sc;
	private EmployeeController ec;

	public FrontController() {
		sc = new Scanner(System.in);
		ec = new EmployeeController();
	}
	
	public void run() throws UsernameAlreadyExistsException {
		boolean run = true;
		
		while(run) {
			System.out.println("Welcome! What would you like to do:");
			System.out.println("Register");
			System.out.println("Login");
			System.out.println("Exit");
			
			String choice = sc.nextLine();
			
			switch(choice) {
			case "Register":
				ec.registerEmployee(sc);
				// TODO: if an employee is not registered, display a different message
				System.out.println("Registeration was not susseful");
				break;
			case "Login":
				break;
			case "Exit":
				run = false;
				break;
			default:
				System.out.println("Invalid input.");
			}
		}
		
		sc.close();
	}

}
