package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.exceptions.EmployeeAlreadyExistsException;
import com.revature.models.Users;
import com.revature.repositories.UserDao;
import com.revature.services.UserService;

@ExtendWith(MockitoExtension.class)

public class UserServiceTest{
	
	@Mock
	private UserDao ed;
	
	@InjectMocks
	private UserService es;
	
	@Test	
	public void addEmployeeTestValid() {
	Users emp = new Users("username", "firstName", "lastName", "password", "email",2);
		
		Mockito.when(ed.addEmployee(new Users("username", "firstName", "lastName", "password","email", 2))).thenReturn(emp);
		
		Users expected = new Users("username", "firstName", "lastName", "password","email",2);
		
		Users actual;
		try {
			actual = es.addEmployee(new Users("username", "firstName", "lastName", "password","email",2));
			assertEquals(expected, actual);
		} catch (EmployeeAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test	
	public void updateEmployeeTestValid() {		
		Mockito.when(ed.updateEmployee(new Users("username", "firstName", "lastName", "password1","email", 2))).thenReturn(true);
		
		boolean expected = true;
		
		boolean actual;
		actual = es.updateEmployee(new Users("username", "firstName", "lastName", "password1","email",2));
		assertEquals(expected, actual);
		
	}
	
	@Test	
	public void loginTest() {
		
	}
	
	
}