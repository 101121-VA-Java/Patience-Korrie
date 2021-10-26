package repositories;

import models.Employee;

public interface EmployeeDao {
	Employee[] getAllEmployees(); // returns an array of all of the employees available
	Employee getEmployeeById(int id);
	int addEmployee(Employee em); // returns assigned id
	boolean editEmployee(Employee em);  //returns boolean depending on operation success 
	boolean deleteEmployee(int id);  //returns boolean depending on operation success 
}

