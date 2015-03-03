package com.main.spendwisely.dao;

// For now its a bad design to use a factry design pattern but just did
// it for trial purposes

public interface AbstractDao {

	void storeWeeklyExpense(double amount, String description, int week,
			int month,int year);
	
	

}
