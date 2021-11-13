package com.revature.repositories;

import java.util.List;

import com.revature.models.Users;



public interface UserDao {
	List<Users> getAllEmployee();
	Users getEmployeeById(int id);
	Users addEmployee(Users employee);
	boolean updateEmployeer(Users employee);
}
