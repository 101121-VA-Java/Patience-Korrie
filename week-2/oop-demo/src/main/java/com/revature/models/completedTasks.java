package com.revature.models;

import java.util.Random;

public class completedTasks extends Task{
	
	
	
	
	public void completedTask(String task1) {
		completedTasks = completedTasks.concat(task1);
		
	}
	public void completedTask(String task1, String task2) {
		completedTasks = completedTasks.concat(task1);
		completedTasks = completedTasks.concat(task2);

	}

	
	@Override
	public String toString() {
		return "Overriding test" ;
	}
	
	@Override
	public int randomNum() {
		
		Random random = new Random();	
		return  (int) Math.round(Math.random()*100) + 100;	
	}
		
}
