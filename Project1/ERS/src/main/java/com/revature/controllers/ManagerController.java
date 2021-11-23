package com.revature.controllers;

import java.util.List;

import com.revature.exceptions.EmployeeAlreadyExistsException;
import com.revature.models.Users;
import com.revature.services.UserService;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;


public class ManagerController {
	private static UserService us = new UserService();
	
	
	public static void getAllEmployees(Context ctx) {
		
		List<Users> emps =us.getAllUsers();
		
		ctx.json(emps);
	}
	
	public static void registerEmployee(Context ctx) {
		Users newUser;
		try {
			newUser = us.addEmployee(ctx.bodyAsClass(Users.class));
			if (newUser == null) {
				ctx.status(HttpCode.BAD_REQUEST);
			} else {
				ctx.status(HttpCode.CREATED);
			}
		} catch (EmployeeAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
