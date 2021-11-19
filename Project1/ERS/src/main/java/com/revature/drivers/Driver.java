package com.revature.drivers;

import io.javalin.Javalin;
import static io.javalin.apibuilder.ApiBuilder.*;
import static io.javalin.apibuilder.ApiBuilder.post;


import com.revature.controllers.AuthController;
import com.revature.controllers.ManagerController;

public class Driver {

	
	public static void main(String[] args) {
		Javalin app = Javalin.create( (config) -> {
			config.enableCorsForAllOrigins();
		
		}).start();
		
		app.before(ctx -> {
		    ctx.header("Access-Control-Allow-Headers", "Authorization");
		    ctx.header("Access-Control-Expose-Headers", "Authorization");
		});
		
		app.routes(() -> {
			path("manager", () -> {
				get(ManagerController::getAllEmployees);
				
			});
			
			path("auth", () ->{
				post(AuthController::login);
			});		
		});
	}
}
