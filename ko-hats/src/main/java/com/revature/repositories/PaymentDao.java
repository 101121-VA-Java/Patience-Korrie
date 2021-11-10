package com.revature.repositories;

import java.util.List;

import com.revature.models.Payments;

public interface PaymentDao {
	Payments viewRemainingPay();
	List<Payments> viewAllPay();
	Payments calWeeklyPays();
	Payments makeaPayment();
}
