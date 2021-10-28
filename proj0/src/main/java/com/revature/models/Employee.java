package com.revature.models;

import java.util.Objects;

public class Employee extends User{
	
	private Employee manager;
	
	User emUser= new User();


	public Employee(int i) {
		super();
	}


	public Employee(Employee manager, User emUser) {
		super();
		this.setManager(manager);
		this.emUser = emUser;
	}
	
	

	public Employee(int id, String name, String username, String password, Roles role, Employee manager) {
		super(id, name, username, password, role, manager);
		// TODO Auto-generated constructor stub
	}


	public Employee getManager() {
		return manager;
	}


	public void setManager(Employee manager) {
		this.manager = manager;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(emUser, manager);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(emUser, other.emUser) && Objects.equals(manager, other.manager);
	}


	@Override
	public String toString() {
		return "Employee [manager=" + manager + ", emUser=" + emUser + "]";
	}
	
	

	
}

	

	