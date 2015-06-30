package com.main.spendwisely.services;

import com.main.spendwisely.dto.MonthlyListDto;

public interface MonthlyService {

	
	public void addSalary(double amount,int fromMonth,int toMonth,int fromYear,int toYear);

	public MonthlyListDto retrieveExpenses(int fromMonth, int toMonth, int fromYear,
			int toYear);
}
