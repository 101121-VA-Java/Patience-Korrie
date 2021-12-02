package com.revature.drivers;

import io.javalin.Javalin;
import static io.javalin.apibuilder.ApiBuilder.*;
import static io.javalin.apibuilder.ApiBuilder.post;
//import static io.javalin.apibuilder.ApiBuilder.put;



import com.revature.controllers.AuthController;
import com.revature.controllers.EmployeeController;
//import com.revature.controllers.EmployeeController;
import com.revature.controllers.ManagerController;
import com.revature.controllers.ReimbController;

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
				path("employees", () ->{
					get(ManagerController::getAllEmployees);
				});
				
				path("update", () -> {	
					put(ManagerController::updateEmployeeInfo); //An Employee can view their information
					
				});
				
				path("{id}", () -> {
					get(ManagerController::getEmployeeById);
				});
				
				
			});
			
//			 /employee
			path("employee", () -> {
			
				path("{id}", () -> {
					get(EmployeeController::getEmployeeById);
					});
				path("update", ()->{				
						put(EmployeeController::updateEmployee);
					});
				
			});
			// /reimb
			path("reimb", () ->{
				
				path("request", ()->{				
					post(ReimbController::makeReqt);
				});
				
				path("getReimb", ()->{				
					get(ReimbController:: getReimb);
				});
				
				path("{id}", ()->{				
					put(ReimbController::update);
				});
				
				path("{author}", () -> {
					get(ReimbController:: getReimb);
				});
				
			});
				
				
		});				
				
	}
}
