package com.revature.interfaces;

public interface jumpable extends stepable{ //interface class
	public static final int steps = 4;
	
	default void step() {
		System.out.println("Default implementation");
	}
	
	@Override
	public default void doJumpOrStep(){
		System.out.println("Jumping");
		
	}
	
}
