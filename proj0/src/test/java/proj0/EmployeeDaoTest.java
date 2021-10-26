package proj0;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.Employee;
import models.Roles;
import repositories.EmployeeArray;
import repositories.EmployeeDao;

public class EmployeeDaoTest {

	private static EmployeeDao ed;
	
	@BeforeEach
	public void setup() {
		Employee[] employees = {new Employee(0, "Kevin", "Kev", "KevPass",Roles.Empolyee, null)}; 

		ed = new EmployeeArray(employees);
	}
	
	@Test
	public void getAllEmployees(){
		Employee[] expected = {new Employee(0, "Kevin", "Kev", "KevPass",Roles.Empolyee, null)};
		Employee[] actual = ed.getAllEmployees();
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void addEmployeeValid() {
		Employee[] expected = {new Employee(0, "Kevin", "Kev", "KevPass",Roles.Empolyee, null), 
								new Employee(1, "Kev", "K", "Pass",Roles.Empolyee, null) };
		
		// Adding an employee
		ed.addEmployee(new Employee(1, "Kev", "K", "Pass",Roles.Empolyee, null));
		
		assertArrayEquals(expected, ed.getAllEmployees());
	}
}
