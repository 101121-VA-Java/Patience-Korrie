package com.revature.services;

import java.util.List;

import com.revature.models.Customer;
import com.revature.models.Roles;
import com.revature.repositories.CustomerDao;
import com.revature.repositories.CustomerList;

public class CustomerService {
	
	private CustomerDao cd = new CustomerList();
	
	
	public Customer addCustomer(Customer cs) throws UsernameAlreadyExistsException {
		Customer newCust = this.getCustomerByUsername(cs.getUsername());
		if(newCust != null) {
			throw new UsernameAlreadyExistsException();
		}
		cs.setRole(Roles.Customer);
		return cd.addCustomer(cs);
	}


	private Customer getCustomerByUsername(String username) {
		List<Customer> customers = cd.getAllCustomer();
		for(Customer i :customers) {
			if(i.getUsername().equals(username)) {
				return i;
			}
		}
		return null;
	}
	
	public Customer getCustomerById(int id) {
		return cd.getCustomerById(id);
	}
	
	

	

}
