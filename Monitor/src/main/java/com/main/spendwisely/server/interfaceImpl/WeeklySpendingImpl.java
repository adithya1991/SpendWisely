package com.main.spendwisely.server.interfaceImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.spendwisely.dto.WeeklyListDto;
import com.main.spendwisely.server.interfaces.WeeklySpendingWebService;
import com.main.spendwisely.services.WeeklyService;


public class WeeklySpendingImpl implements WeeklySpendingWebService{
	
	@Autowired
	private WeeklyService weeklyService;
	
	@Override
	public void storeExpense(double amount, int month,int week,int year, String description) {
		// now we need to store all these details into the week table
		// and add it to the current total of the month as well 
		
		weeklyService.storeWeekExpense(amount, description, week,month,year);
		
	}

	@Override
	public WeeklyListDto retrieveExpenses(int fromWeek,int toWeek,int fromMonth, int toMonth) {
		
		return null;
	}

	

}
