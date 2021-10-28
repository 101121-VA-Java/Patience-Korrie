package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.models.Employee;
import com.revature.models.Roles;
import com.revature.repositories.EmployeeList;
import com.revature.repositories.EmployeeDao;

public class EmployeeDaoTest {

	private EmployeeDao ed = new EmployeeList();
	
	@BeforeEach
	public void setup() {
		ed = new EmployeeList();
	}
	
	@Test
	public void getAllEmployees(){
		List<Employee> expected = new ArrayList<>();
		expected.add(new Employee(0, "Enrollment Admin", "Enrollment Admin", "AdminPass", Roles.System, null));
		
		assertEquals(expected, ed.getAllEmployees());
	}
	
	@Test
	public void addEmployeeValid() {
		List<Employee> expected = new ArrayList<>();
		expected.add(new Employee(0, "Enrollment Admin", "Enrollment Admin", "AdminPass", Roles.System, null));
		expected.add(new Employee(1, "Test User", "Test User", "TestPass", Roles.Empolyee, new Employee(0)));
		
		ed.addEmployee(new Employee(0, "Test User", "Test User", "TestPass", Roles.Empolyee, new Employee(0)));
		assertEquals(expected, ed.getAllEmployees());
	}
}
