package com.revature.repositories;

import java.util.ArrayList;
import java.util.List;


import com.revature.models.Employee;
import com.revature.models.Roles;

public class EmployeeList implements EmployeeDao{
	private List<Employee> employees;
	
	public EmployeeList() {
		employees = new ArrayList<>();
		Employee System = new Employee(0, "System", "System", "SysPass", Roles.System, 0);
		employees.add(System);
		
	}
	
	
	@Override
	public List<Employee> getAllEmployees() {
		return employees;
	}
	
	
	@Override
	public Employee getEmployeeById(int id) {
		// Iterate to see if employees contain the id
				for (Employee e : employees) {
					// returns the employee if found
					if (e.getId() == id) {
						return e;
					}
				}
				// returns null otherwise
				return null;
	}



	@Override
	public Employee addEmployee(Employee em) {
		em.setId(employees.size());
		// add method returns true if adding to a collection was successful
		employees.add(em);
		return em;
	}


}

	