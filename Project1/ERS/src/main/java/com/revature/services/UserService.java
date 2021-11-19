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
	
	public Users getEmployeeByUsername(String username) {
		List<Users> employees = ud.getAllEmployee();
		for(Users e : employees) {
			if(e.getUsername().equals(username)) {
				e.setPassword(null);
				return e;
			}
		}
		return null;
	}
	
	public Users getEmployeeById(int id) {
		return ud.getEmployeeById(id);
	}
	
	public boolean updateEmployee(Users employee) {
		return ud.updateEmployee(employee);
		
	}
	
	
	
	public String login(String username, String password) throws LoginException {
		List<Users> employees = ud.getAllEmployee();
		String token = null;
		for(Users i : employees) {
			if (i.getUsername().equals(username)&& i.getPassword().equals(password)) {
				String role = i.getRole().getRole();
				token = i.getId() + ":" + role;
				return token;
				}
			}
		throw new LoginException();
		}
	
//	public boolean checkPermission( String token, Roles...allowedRoles) {
//		
//		/*
//		 * Behavior to identify user using token
//		 */
//		// this indicates that a user is not authenticated
//		if(token == null) {
//			return false;
//		}
//		
//		return false;
//		
//	}
	
	
	
	
	
}
