package com.revature.repositories;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Hat;

public class HatList implements HatDao{
	private List<Hat> hats;
	
	

	public HatList() {
		hats = new ArrayList<>();
		Hat Bucket = new Hat(0,"Bucket", 10, "Black", "M");
		hats.add(Bucket);
	}

	@Override
	public List<Hat> getAllHats() {
		return hats;
	}

	@Override
	public Hat getHatById(int id) {
		for (Hat h : hats) {
			if (h.getId() == id) {
				return h;
			}
		}
		return null;
	}

	@Override
	public Hat addHat(Hat hat) {
		hat.setId(hats.size());
		hats.add(hat);
		return hat;
	}

	@Override
	public boolean editHat(Hat eh) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeHat(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
