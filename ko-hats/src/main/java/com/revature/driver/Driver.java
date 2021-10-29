package com.revature.driver;


import com.revature.controllers.FrontController;
import com.revature.services.UsernameAlreadyExistsException;


public class Driver {
	
	public static void main(String[] args) throws UsernameAlreadyExistsException {
		FrontController fc = new FrontController();
		fc.run();

	}

}
