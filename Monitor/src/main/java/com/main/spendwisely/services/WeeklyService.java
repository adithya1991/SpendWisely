package com.main.spendwisely.services;

public interface WeeklyService {
	
	public void storeWeekExpense(double amount ,String description, int ...wMo);
	
	public void getWeeklyExpense(int fromWeek,int toWeek,int fromMonth, int toMonth);
	
	

}
