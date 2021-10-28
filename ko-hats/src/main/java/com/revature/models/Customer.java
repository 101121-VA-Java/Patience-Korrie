package com.revature.models;

//import java.util.Objects;

public class Customer extends User {
	
	User cmUser= new User();
	
	public Customer() {
		// TODO Auto-generated constructor stub
		super();
	}

	public Customer(int id, String name, String username, String password, Roles role, Employee manager) {
		super(id, name, username, password, role, manager);
	}

	public Customer(User cmUser) {
		super();
		this.cmUser = cmUser;
	}
	
	
	
}
