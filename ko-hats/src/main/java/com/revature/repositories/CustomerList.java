package com.revature.repositories;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Customer;
import com.revature.models.Roles;

public class CustomerList implements CustomerDao {
	private List<Customer> customers;

	public CustomerList() {
		customers = new ArrayList<>();
		Customer jake= new Customer(0, "jake", "jk", "jPass", Roles.Customer, -1);//ask about -1
		customers.add(jake);
	}




	@Override
	public List<Customer> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer addEmployee(Customer cs) {
		// TODO Auto-generated method stub
		return null;
	}


	

}
