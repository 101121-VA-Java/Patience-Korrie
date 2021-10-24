package com.revature.interfaces;

public interface stepable {
	
	default void step() {
		System.out.println("Default implementation from step");
	}
	
	public abstract void doJumpOrStep();//abstract method
	
}
