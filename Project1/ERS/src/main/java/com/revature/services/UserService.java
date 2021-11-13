package com.revature.services;

import java.util.List;

import com.revature.exceptions.EmployeeAlreadyExistsException;
import com.revature.exceptions.LoginException;
import com.revature.models.Users;
import com.revature.repositories.UserDao;
import com.revature.repositories.UserPostgres;

public class UserService {
	
	private UserDao ud = new UserPostgres();
	
	public List<Users> getAllUsers(){
		return ud.getAllEmployee();
		
	}
	
	public Users addEmployee(Users employee) throws EmployeeAlreadyExistsException {
		Users newEmp = this.getEmployeeByUsername(employee.getUsername());
		if(newEmp != null) {
			throw new EmployeeAlreadyExistsException();
		}
		return ud.addEmployee(employee);
	}
	
	private Users getEmployeeByUsername(String username) {
		List<Users> employees = ud.getAllEmployee();
		for(Users e : employees) {
			if(e.getUsername().equals(username)) {
				return e;
			}
		}
		return null;
	}
	
	public boolean updateEmployeer(Users employee) {
		return ud.updateEmployeer(employee);
		
	}
	
	public Users login(String username, String password) throws LoginException {
		List<Users> employees = ud.getAllEmployee();
		for(Users i : employees) {
			if (i.getUsername().equals(username)&& i.getPassword().equals(password)) {
				return i;
				}
			}
		throw new LoginException();
		}
}
