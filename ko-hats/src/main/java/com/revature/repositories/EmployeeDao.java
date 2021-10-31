package com.revature.repositories;

import java.util.List;

import com.revature.models.Employee;

public interface EmployeeDao {
	List<Employee> getAllEmployees();
	Employee getEmployeeById(int id);
	Employee addEmployee(Employee em);
	 
}

