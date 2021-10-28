package com.revature.repositories;

import com.revature.models.Customer;

public class CustomerItems<itemsOwned> implements CustomerDao {
	private itemsOwned[] items;

	public CustomerItems() {
		super();
	}
	
	public CustomerItems(itemsOwned[] items) {
		this.items = items;
	}



	@Override
	public Customer[] viewAvailableItem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer makeOffer(String item) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Customer itemsOwned(itemsOwned[] iO) {
//		return this.items;
//	}
}
