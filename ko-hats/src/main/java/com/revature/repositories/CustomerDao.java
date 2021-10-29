package com.revature.repositories;

import java.util.List;

import com.revature.models.Customer;

public interface CustomerDao {
	List<Customer> getAllEmployees(); // returns an array of all of the employees available
	Customer getEmployeeById(int id);
	Customer addEmployee(Customer cs); 
	
}
