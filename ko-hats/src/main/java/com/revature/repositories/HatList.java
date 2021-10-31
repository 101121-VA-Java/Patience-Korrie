package com.revature.repositories;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Hat;

public class HatList implements HatDao{
	private List<Hat> hats;
	
	

	public HatList() {
		hats = new ArrayList<>();
		Hat Bucket = new Hat(0,"Bucket", 10, "Black", "M", false);
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
		for(Hat i : hats) {
			if(i.getId() == hat.getId()) {
				return hat;
			}
		}
		return null;
			
		
	}

	@Override
	public boolean editHat(Hat eh) {
		for(Hat i : hats) {
			if(i.equals(eh)|| getHatById(eh.getId()) == null) {
				return false;
			}
			hats.set(i.getId(), eh);//check if it works
		}
		
		return true;
	}

	@Override
	public boolean removeHat(int id) {
		for(Hat i : hats) {
			if(i.getId()==id) {
				hats.remove(id);//removing just the id..test
			}
		}
		return false;
	}

}
