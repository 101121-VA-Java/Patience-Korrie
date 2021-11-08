package com.revature;

//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import com.revature.models.Employee;
//import com.revature.models.Roles;
//import com.revature.repositories.EmployeeList;
//import com.revature.repositories.EmployeeDao;
//
//public class EmployeeDaoTest {
//
//	private EmployeeDao ed = new EmployeeList();
//	
////	@BeforeEach
//	public void setup() {
//		ed = new EmployeeList();
//	}
//	
//	@Test
//	public void getAllEmployees(){
//		List<Employee> expected = new ArrayList<>();
//		expected.add(new Employee(0, "System", "System", "SysPass", System, 0));
//		
//		assertEquals(expected, ed.getAllEmployees());
//	}
//	
//	@Test
//	public void addEmployee() {
//		List<Employee> expected = new ArrayList<>();
//		expected.add(new Employee(0, "System", "System", "SysPass", Roles.System, 0));
//		expected.add(new Employee(1, "TestU1", "TestU2", "TestPass", Roles.Empolyee, 0));
//		
//		ed.addEmployee(new Employee(1, "Test User", "Test User", "TestPass", Roles.Empolyee, 0));
//		assertEquals(expected, ed.getAllEmployees());
//	}
//	
//	@Test
//	public void getEmployeeById() {
//		Employee expected = new Employee(0, "System", "System", "SysPass", Roles.System, 0);
//		
//		assertEquals(expected, ed.getEmployeeById(0));
//	}
//}
