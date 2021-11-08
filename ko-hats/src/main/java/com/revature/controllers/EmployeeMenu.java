package com.revature.controllers;

import java.util.List;
import java.util.Scanner;

import com.revature.exceptions.HatAlreadyExistsException;
import com.revature.exceptions.HatDoesNotExistException;
import com.revature.exceptions.UsernameDoesNotExistsException;
import com.revature.models.Employee;
import com.revature.models.Hat;
import com.revature.services.EmployeeService;
import com.revature.services.HatService;

public class EmployeeMenu {
	private static HatService hs = new HatService();
	private static EmployeeService es = new EmployeeService();
	

	public void addNewHat(Scanner scan) {
		System.out.println("Please enter: ");
		System.out.println("Type: ");
		String type = scan.nextLine();
		System.out.println("Price: ");
		String price1 = scan.nextLine();
		int price = Integer.parseInt(price1);
		System.out.println("Color: ");
		String color = scan.nextLine();
		System.out.println("Size: ");
		String size = scan.nextLine();
		
		Hat newHat = new Hat(type, price, color, size);
		
		try {
			newHat = hs.addHat(newHat);
			System.out.println("Hat has been added!");
		} catch (HatAlreadyExistsException e) {
			System.out.println("Hat already exists");
		}
		
	}
	
	public void removeExitingHat(Scanner scan) {
		List<Hat> hats =hs.getAllHats();
		if(hats != null) {
			for(Hat i : hats) {
				System.out.println(i);
			}
		System.out.println("Please select the hat you would like to delete by Id");
		int id = Integer.parseInt(scan.nextLine());
		
		Hat rmHat = new Hat(id);
		
		try {
			hs.removeHatById(rmHat.getId());
		} catch (HatDoesNotExistException e) {
			e.printStackTrace();
		}
		System.out.println("Hat has been removed!");
	}else {
		System.out.println("No Hats avaliable");
		}
	}
	
	public void removeEmp(Scanner scan) {
		System.out.println("Please enter Employee: ");
		String emp = scan.nextLine();
		Employee rmEmp= new Employee(emp);
		try {
			es.deleteEmployee(rmEmp.getId());
		} catch (UsernameDoesNotExistsException e) {
			e.printStackTrace();
		}
		System.out.println("Employee has been removed!");
	}
	
	
}
