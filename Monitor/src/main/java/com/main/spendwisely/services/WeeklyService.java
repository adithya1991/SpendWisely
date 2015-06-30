package com.main.spendwisely.services;

import com.main.spendwisely.dto.WeeklyListDto;

public interface WeeklyService {
	
	public void storeWeekExpense(double amount ,String description, int ...wMo);
	
	public WeeklyListDto getWeeklyExpense(int fromWeek,int toWeek,int fromMonth, int toMonth);
	
	

}
