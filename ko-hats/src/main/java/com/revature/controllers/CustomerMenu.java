package com.revature.controllers;


import java.util.Scanner;

import com.revature.exceptions.SubscriberAlreadyExistsException;
import com.revature.models.Offers;
import com.revature.models.Subscribe;
//import com.revature.services.CustomerService;
import com.revature.services.HatService;
import com.revature.services.OffersService;
import com.revature.services.PaymentService;
import com.revature.services.SubscribeService;

public class CustomerMenu {
	private static HatService hs = new HatService();
	private static OffersService os = new OffersService();
	private static PaymentService ps = new PaymentService();
	private static SubscribeService ss = new SubscribeService();
	
	
	public void viewAllAvaliableHats(Scanner scan) {
		System.out.println(hs.getAllAvaliableHats());
	}
	
	public void makeOffer(Scanner scan) {
		System.out.println("Please enter: ");
		System.out.println("Hat ID: ");
		int hatId =  Integer.parseInt(scan.nextLine());
		System.out.println("Offer: ");
		double offer = Double.parseDouble(scan.nextLine());
		
		Offers newOffer = new Offers(hatId,offer);
		newOffer = os.makeOffer(newOffer) ;
		System.out.println("Offer has been added!");
	}
	
	public void viewOwnedHats(Scanner scan) {
		System.out.println(hs.viewOwnedHats());
	}
	
	public void makeaPayment(Scanner scan) {
		System.out.println(ps);
	}
	
	public void addSubscriber(Scanner scan) {
		System.out.println("Would you like to subscribe to KoHats? yes or no");
		String action = scan.nextLine();
		Subscribe subs = new Subscribe();
		if(action.toLowerCase().trim().equals("yes")) {
			try {
				subs= ss.addSubscriber(subs);
			} catch (SubscriberAlreadyExistsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("You have been added");
	}else {
		System.out.println();
		}
	}
	
}
