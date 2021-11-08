package com.revature.controllers;

import java.util.Scanner;


//import com.revature.services.CustomerService;
import com.revature.services.HatService;

public class CustomerMenu {
	private static HatService hs = new HatService();
//	private static CustomerService es = new CustomerService();
	
	
	public void viewAllAvaliableHats(Scanner scan) {
		System.out.println(hs.getAllAvaliableHats());
	}
	
}
