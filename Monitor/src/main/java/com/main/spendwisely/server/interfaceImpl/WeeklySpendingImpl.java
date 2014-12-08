package com.main.spendwisely.server.interfaceImpl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.main.spendwisely.dto.WeeklyListDto;
import com.main.spendwisely.server.interfaces.WeeklySpending;

@Service("WeeklySpending")
public class WeeklySpendingImpl implements WeeklySpending{

	@Override
	public void storeExpense(double amount, int month, String description) {
		
		
	}

	@Override
	public WeeklyListDto retrieveExpenses(int fromWeek,int toWeek,int fromMonth, int toMonth) {
		
		return null;
	}

	

}
