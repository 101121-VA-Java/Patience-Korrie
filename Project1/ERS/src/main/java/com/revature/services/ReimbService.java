package com.revature.services;

import java.util.List;

import com.revature.models.Reimb;
import com.revature.repositories.ReimbDao;
import com.revature.repositories.ReimbPostgres;

public class ReimbService {
	
	private ReimbDao rd = new ReimbPostgres();
	
	public List<Reimb> getAllReimb(){
		return rd.getAllReimb();
		
	}
	
	public Reimb addReimb(Reimb reimb) {
		return rd.addReimb(reimb);
	}
	
	public int getReimbById(int id) {
		return id;
		
	}
	
}
