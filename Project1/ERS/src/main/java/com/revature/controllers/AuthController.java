package com.revature.controllers;

import com.revature.services.UserService;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class AuthController {
	private static UserService us = new UserService();
	
	public static void login(Context ctx) {
		String username = ctx.formParam("username");
		String password = ctx.formParam("password");
		
		String token = null;
		
		if(username != null && password != null) {
				token = us.login(username, password);
		}
		
		if(token != null) {
			ctx.header("Authorization", token);
			ctx.status(HttpCode.OK);
		} else {
			ctx.status(HttpCode.NOT_FOUND);
		}
	}
}
