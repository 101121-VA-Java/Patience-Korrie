package com.revature.controllers;

import java.util.List;

import com.revature.models.Users;
import com.revature.services.UserService;

import io.javalin.http.Context;


public class ManagerController {
	private static UserService us = new UserService();
	
	
	public static void getAllEmployees(Context ctx) {
		
		List<Users> emps =us.getAllUsers();
		
		ctx.json(emps);
		
	}
}
