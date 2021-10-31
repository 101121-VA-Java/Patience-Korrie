package com.revature.services;

import com.revature.exceptions.HatAlreadyExistsException;
import com.revature.models.Hat;
import com.revature.repositories.HatDao;
import com.revature.repositories.HatList;

public class HatService {
	
	private HatDao hs = new HatList();

	public Hat addHat(Hat h) throws HatAlreadyExistsException {
		Hat newHat = this.getHatById(h.getId());
		if(newHat != null) {
			throw new HatAlreadyExistsException();
		}
		
		return hs.addHat(h);
	}

	private Hat getHatById(int id) {
		return hs.getHatById(id);
	}
	
	

}
