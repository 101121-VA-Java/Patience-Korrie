package com.revature.services;

import java.util.List;


import com.revature.exceptions.EmployeeAlreadyExistsException;
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
		List<Users> employees = getAllUsers();
		System.out.println(employees);
		for(Users e : employees) {
			System.out.println(e.getUsername());
			if(e.getUsername().equals(username)) {				
				return e;
			}
		}
		return null;
	}
	
	public Users getEmployeeById(int id) {
		return ud.getEmployeeById(id);
	}
	
	public boolean updateEmployee(Users e) {
		return ud.updateEmployee(e);
		
	}
	
	public boolean updateEmployeeRole(Users e) {
		Users u_update = ud.getEmployeeById(e.getId());
		if(e.getRole() != null && !e.getRole().equals(u_update.getRole())) {
			u_update.setRole(e.getRole());
		}
		return ud.updateEmployee(u_update);
	}
	
	
	
	public String login(String username, String password)  {
		Users employee = getEmployeeByUsername(username);
		String token = null;
		System.out.println(employee.getUsername() + " pass " + employee.getPassword());
		
			if (employee!=null &&  employee.getPassword().equals(password)) {
				
				token = employee.getId() + ":" + employee.getRole().getId();
				}
			return token;
		}
	
	
//	public boolean checkPermission( String token, Roles...allowedRoles) {
//		
//		if(token == null) {
//			return false;
//		}
//		
//		String[] info = token.split(":"); 
//		// retrieve user id
//		int token_id = Integer.parseInt(info[0]);
//		// retrieve user role
//		int token_role = Integer.parseInt(info[1]);
//		
//		Users principal = ud.getEmployeeById(token_id);
//		int principal_role = principal.getRole().getId();
//		if(principal != null && token_role==principal_role
//				&& Arrays.asList(allowedRoles).contains(token_role)) {//errorr
//			return true;
//		}
//		
//		return false;
//		
//	}
	
	
	
	
	
}
