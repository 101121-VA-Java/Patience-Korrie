package com.revature.controllers;

import java.util.List;

import com.revature.models.Reimb;
import com.revature.services.ReimbService;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;


public class ReimbController {
	
	private static ReimbService rs = new ReimbService();
	
	public static void makeReqt(Context ctx) {

		Reimb r = ctx.bodyAsClass(Reimb.class);
		r.setStatusId(1);

		r = rs.addReimb(r);
			
			if (r.getId() == 0) {
				ctx.status(HttpCode.BAD_REQUEST);
			} else {
				ctx.status(HttpCode.CREATED);
			}
		}
	
	
	
	public static void getAllReimb(Context ctx) {
		String token = ctx.header("Authorization");
		if(token.split(":")[1].equals("2")) {
			List <Reimb> rmbs = null;
			if(ctx.queryParam("author") == null) {
				rmbs = rs.getAllReimb();
			}
			else {
				int authorId =  Integer.parseInt(ctx.pathParam("author"));
				rmbs = rs.getReimbsById(authorId);
			}
			
			if(rmbs == null)ctx.status(HttpCode.BAD_REQUEST);
			else ctx.json(rmbs); ctx.status(HttpCode.CREATED);
		}else {
			ctx.status(HttpCode.UNAUTHORIZED);
			}
	}
	
	public static void getAllResolvedReqt(Context ctx) {
		String token = ctx.header("Authorization");
		
		if(token.split(":")[1].equals("2")) {
			List <Reimb> rmbs = null;
			rmbs = rs.getAllResolvedRequest();
			
			if(rmbs == null)ctx.status(HttpCode.BAD_REQUEST);
			else ctx.json(rmbs); ctx.status(HttpCode.CREATED);
			}else {
				ctx.status(HttpCode.UNAUTHORIZED);
				}
	}
	
	
	public static void getAllResolvedReimb(Context ctx) {
		String token = ctx.header("Authorization");
		List <Reimb> rmbs = null;
		if(token.split(":")[1].equals("1")) {
			int empId = Integer.parseInt(token.split(":")[0]);
			 rmbs = rs.getAllResolved(empId);
			 
			 if(rmbs == null) ctx.status(HttpCode.BAD_REQUEST);
				else ctx.json(rmbs); ctx.status(HttpCode.CREATED);
			} else {
			ctx.status(HttpCode.UNAUTHORIZED);
			}
		}
		
	public static void getAllPendingReimb(Context ctx) {
		String token = ctx.header("Authorization");
		List <Reimb> rmbs = null;
		
		if(token.split(":")[1].equals("1")) {
		int empId = Integer.parseInt(token.split(":")[0]);
		 rmbs = rs.getPendings(empId);
		 
		 if(rmbs == null) ctx.status(HttpCode.BAD_REQUEST);
			else ctx.json(rmbs); ctx.status(HttpCode.CREATED);
		} 
		else {
		ctx.status(HttpCode.UNAUTHORIZED);
		}
	}

	public static void update(Context ctx) {
		String token = ctx.header("Authorization");
		if(token.split(":")[1] !="2") {
			ctx.status(HttpCode.UNAUTHORIZED);
			return;
		}
		
		int id = Integer.parseInt(ctx.pathParam("id"));
		String str = ctx.body();
		int statusId = Integer.parseInt(str);
	
		Reimb r = rs.getReimbById(id);
		r.setStatusId(statusId);
		String[] info = token.split(":"); 
		int managerId = Integer.parseInt(info[0]);
		r.setResolverId(managerId);
		Boolean result = rs.update(r);
		
		if (!result) {
			ctx.status(HttpCode.BAD_REQUEST);
		} else {
			System.out.println("yayy");
			ctx.status(HttpCode.CREATED);
		}
	}

}
