package com.revature.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.management.relation.Role;

import com.revature.models.Employee;
import com.revature.models.Roles;

public class EmployeeList implements EmployeeDao{
	private List<Employee> employees;
	
	public EmployeeList() {
		employees = new ArrayList<>();
		// System defined EnrollmentAdmin User added to the employees list to be used as
		// default admin for all new user
		Employee System = new Employee(0, "Enrollment Admin", "Enrollment Admin", "AdminPass", Roles.System,
				null);
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





	@Override
	public boolean updateEmployee(Employee em) {
		Employee temp = getEmployeeById(em.getId());
		if (temp == null || temp.equals(em)) {
			return false;
		}
		employees.set(em.getId(), em);
		return true;
	}





	@SuppressWarnings("unlikely-arg-type")
	@Override
	public boolean deleteEmployee(int id) {
		employees.removeIf(employees -> employees.equals(id));
		return false;
	}
}

	