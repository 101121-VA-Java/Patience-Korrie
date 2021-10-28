package com.revature.services;

import com.revature.models.Employee;
import com.revature.repositories.EmployeeDao;
import com.revature.repositories.EmployeeList;

public class EmployeeService {
	
	private EmployeeDao ed;

	public EmployeeService() {
		super();
		ed = new EmployeeList();
	}
	
	public Employee addEmployee(Employee e) {
		/*
		 * add business logic here to manipulate e before storage
		 */
		return ed.addEmployee(e);
	}
	
	
	public Employee getEmployeeById(int id) {
		/*
		 * add business logic here to manipulate e before storage
		 */
		return ed.getEmployeeById(id);
	}

}
