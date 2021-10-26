package repositories;

import models.Customer;

public interface CustomerDao {
	Customer[] viewAvailableItem(); // returns an array of all of the  available items
	Customer makeOffer(String item); //
	Customer[] itemsOwned(Customer iO); // returns items Owned
	
}
