package com.main.spendwisely.dao;

public interface WeeklyDao {
	
	public void storeWeeklyExpense(double amount, String description, int week,
			int month,int year);

}
