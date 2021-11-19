package com.revature.controllers;

import com.revature.models.Users;
import com.revature.services.UserService;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class EmployeeController {
	
	private static UserService es = new UserService();
	
	
	public static void getEmployee(Context ctx) {

//		String token = ctx.header("Authorization");
		
		// pathParam("nameOfPathParam");
		int id = Integer.parseInt(ctx.pathParam("id"));
		Users u = es.getEmployeeById(id);
		
		if (u != null) {
			ctx.json(u);
			ctx.status(HttpCode.OK);
		} else {
			ctx.status(404);
			ctx.status(HttpCode.NOT_FOUND);
		}
		
	}
	
	
	
}
