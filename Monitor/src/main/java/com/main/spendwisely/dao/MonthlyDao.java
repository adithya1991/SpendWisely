package com.main.spendwisely.dao;

import com.main.spendwisely.domain.MonthlyData;

public interface MonthlyDao {
	
	public void addSalary(double amount,int fromMonth,int toMonth,int fromYear,int toYear);

	public MonthlyData checkIfMonthRecExists(int month, int year);

	public MonthlyData addNewMonthlyRecord(int year, double amount, int month);

}
