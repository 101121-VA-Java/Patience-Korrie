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
		for(Users e : employees) {
			if(e.getUsername().equals(username)) {				
				return e;
			}
		}
		return null;
	}
	
	public Users getEmployeeById(int id) {
		Users e = ud.getEmployeeById(id);
		if (e != null) {
			e.setPassword(null);
		}
		
		return e;
	}
	
	public boolean updateEmployee(Users e) {
		Users eUpdate = ud.getEmployeeById(e.getId());
		System.out.println(eUpdate);
		if(e.getFirstName() !=null && !e.getFirstName().equals(eUpdate.getFirstName())) {
			eUpdate.setFirstName(e.getFirstName());
			System.out.println(eUpdate +"test");
		}
		
		if(e.getLastName() !=null && !e.getLastName().equals(eUpdate.getLastName())) {
			eUpdate.setLastName(e.getLastName());
		}
		
		if(e.getUsername() !=null && !e.getUsername().equals(eUpdate.getUsername())) {
			eUpdate.setUsername(e.getUsername());
		}
		
		if(e.getPassword() !=null && !e.getPassword().equals(eUpdate.getPassword())) {
			eUpdate.setPassword(e.getPassword());
		}
		if(e.getEmail() !=null && !e.getEmail().equals(eUpdate.getEmail())) {
			eUpdate.setEmail(e.getEmail());
		}
				
			return 	ud.updateEmployee(eUpdate);
		
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
//		
//		int token_id = Integer.parseInt(info[0]);
//		
//		int token_role = Integer.parseInt(info[1]);
//		
//		Users principal = ud.getEmployeeById(token_id);
//		Roles principal_role = principal.getRole();
//		if(principal != null && token_role==principal_role.getId()
//				&& Arrays.asList(allowedRoles).contains(principal_role)) {
//			return true;
//		}
//		
//		return false;
		
	//}
	
	
	
	
	
}
