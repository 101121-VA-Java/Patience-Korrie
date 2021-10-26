package Services;

import models.Customer;
import repositories.CustomerDao;

public class CustomerService {
	
	private CustomerDao cd;

	public CustomerService() {
		// TODO Auto-generated constructor stub
	}
	

	
	
	public Customer[] itemsOwned(Customer iO) {
		/*
		 * add business logic here to manipulate e before storage
		 */
		return cd.itemsOwned(iO);
	}

}
