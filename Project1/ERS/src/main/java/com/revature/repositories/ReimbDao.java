package com.revature.repositories;

import java.util.List;

import com.revature.models.Reimb;

public interface ReimbDao {
List<Reimb> getAllReimb();
Reimb getReimbById(int id);
Reimb addReimb(Reimb reimb);
List<Reimb> getAllPendingReimb();
List<Reimb> viewAllResolvedReimb();
boolean updateReimb(Reimb r);
List<Reimb> getReimbsById(int id);

}
