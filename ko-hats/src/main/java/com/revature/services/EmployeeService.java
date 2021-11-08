package com.revature.services;

import java.util.List;

import com.revature.exceptions.LoginException;
import com.revature.exceptions.UsernameDoesNotExistsException;
import com.revature.models.Employee;
import com.revature.repositories.EmployeeDao;
import com.revature.repositories.EmployeePostgres;

public class EmployeeService {
	
//	private EmployeeDao ed = new EmployeeList();
	private EmployeeDao ed = new EmployeePostgres();

	
	public Employee addEmployee(Employee e) throws UsernameAlreadyExistsException{
		Employee newEmp = this.getEmployeeByUsername(e.getUsername());
		if(newEmp != null) {
			throw new UsernameAlreadyExistsException();
		}
//		e.setRole(Roles.Empolyee);
////		e.setManager(ed.getEmployeeById(0));
		return ed.addEmployee(e);
	}
	
	
	private Employee getEmployeeByUsername(String username) {
		List<Employee> employees = ed.getAllEmployees();
		for(Employee e : employees) {
			if (e.getUsername().equals(username)) {
				return e;
			}
		}
		return null;
	}


	public Employee getEmployeeById(int id) {
		return ed.getEmployeeById(id);
	}
	
	public List<Employee> getAllEmployee() {
		return ed.getAllEmployees();
	}


	public Employee login(String username, String password) throws LoginException {
		List<Employee> employees = ed.getAllEmployees();
		for(Employee i : employees) {
			if (i.getUsername().equals(username)&& i.getPassword().equals(password)) {
				return i;
			}
		}
		throw new LoginException();
	}
	
	public int deleteEmployee(int id) throws UsernameDoesNotExistsException {
		int result =-1;
		Employee rmEmp = this.getEmployeeById(id);
		if(rmEmp != null) {
			throw new UsernameDoesNotExistsException();
		}
		
		result=ed.deleteEmployee(id);
		return result;
	}
	
	

}
