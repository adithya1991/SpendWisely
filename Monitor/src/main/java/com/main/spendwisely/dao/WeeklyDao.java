package com.main.spendwisely.dao;

import java.util.List;

import com.main.spendwisely.domain.WeeklyData;

public interface WeeklyDao {
	
	public void storeWeeklyExpense(double amount, String description, int week,
			int month,int year);

	void updateCorrespondingMonthlyData(double amount, int week, int month, int year);
	
	void createNewWeeklyData(double amount, String description,
			int week, int month, int year);
	
	public WeeklyData checkIfCreateFlow(double amount, int week, int month,
			int year);
	
	public void addDetailedExpenseEntity(double amount, String description,
			int week, int month, int year);
	
	public List<WeeklyData> retrieveAllExpenses(int fromWeek,int toWeek,int fromMonth, int toMonth);

}
