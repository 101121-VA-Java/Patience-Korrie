package com.revature.drivers;

import io.javalin.Javalin;
import static io.javalin.apibuilder.ApiBuilder.*;
import static io.javalin.apibuilder.ApiBuilder.post;
//import static io.javalin.apibuilder.ApiBuilder.put;



import com.revature.controllers.AuthController;
import com.revature.controllers.EmployeeController;
//import com.revature.controllers.EmployeeController;
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
			
			path("auth", () ->{
				post(AuthController::login);
			});	
			
			// /manager
			path("manager", () -> {
				get(ManagerController::getAllEmployees);
		
				post(ManagerController::registerEmployee);
				
			});
			
//			 /employee
			path("employee", () -> {
				path("{id}", () -> {
					get(EmployeeController::getEmployeeById);
				path("account", ()->{				
						get(EmployeeController::updateEmployee); //An Employee can view their information
						put(EmployeeController::updateEmployee);
					});
					
				});
				
				
			});
//			
			
				
		});
	}
}
