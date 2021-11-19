package com.revature.controllers;

import com.revature.exceptions.LoginException;
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
			try {
				token = us.login(username, password);
			} catch (LoginException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(token != null) {
			// pass in the the generated token as the value of the "authorization header"
			ctx.header("Authorization", token);
			ctx.status(HttpCode.OK);
		} else {
			ctx.status(HttpCode.NOT_FOUND);
		}
	}
}
