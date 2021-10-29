package com.revature.repositories;

import java.util.List;

import com.revature.models.Employee;

public interface EmployeeDao {
	List<Employee> getAllEmployees(); // returns an array of all of the employees available
	Employee getEmployeeById(int id);
	Employee addEmployee(Employee em); // returns assigned id
	 
}

