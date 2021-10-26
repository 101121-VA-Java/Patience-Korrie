package Services;

import models.Employee;
import repositories.EmployeeDao;

public class EmployeeService {
	
	private EmployeeDao ed;

	public EmployeeService() {
		// TODO Auto-generated constructor stub
	}
	
	public int addEmployee(Employee e) {
		/*
		 * add business logic here to manipulate e before storage
		 */
		return ed.addEmployee(e);
	}

}
