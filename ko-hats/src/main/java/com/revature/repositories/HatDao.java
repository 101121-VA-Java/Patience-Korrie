package com.revature.repositories;

import java.util.List;

import com.revature.models.Hat;

public interface HatDao {
	List<Hat> getAllHats(); 
	Hat getHatById(int id);
	Hat addHat(Hat hat); 
	boolean editHat(Hat eh);   
	boolean removeHat(int id); 
}