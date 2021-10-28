package com.revature.repositories;

import com.revature.models.Customer;

public interface CustomerDao {
	Customer[] viewAvailableItem(); // returns an array of all of the  available items
	Customer makeOffer(String item); //
	
}
