package com.revature.repositories;

import com.revature.models.Hat;

public interface HatDao {
	Hat[] getAllHats(); // returns an array of all of the employees available
	Hat getHatById(int id);
	int addHat(Hat assgId); // returns assigned id
	boolean editHat(Hat eh);  //returns boolean depending on operation success 
	boolean deleteHat(int id);  //returns boolean depending on operation success 
}