package com.revature.models;

import java.time.LocalDate;

public class BoringTask extends Task{

	public BoringTask() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BoringTask(String name, LocalDate dueDate) {
		super(name, dueDate);
	}
	
	 public void procratinate() {
		 this.setDueDate(this.getDueDate().plusDays(1));
	 }

	@Override
	public String toString() {
		return "BoringTask [getName()=" + getName() + ", getDueDate()=" + getDueDate() + ", toString()="
				+ super.toString() + "]";
	}

	
	

	
	
}
