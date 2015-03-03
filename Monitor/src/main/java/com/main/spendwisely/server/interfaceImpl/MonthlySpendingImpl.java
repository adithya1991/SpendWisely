package com.main.spendwisely.server.interfaceImpl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.main.spendwisely.dto.ErrorCodesType;
import com.main.spendwisely.dto.MonthlyDto;
import com.main.spendwisely.dto.SpendWiselyException;
import com.main.spendwisely.server.interfaces.MonthlySpendingWebService;


public class MonthlySpendingImpl implements MonthlySpendingWebService {

	@Override
	public void addAmount(double amount, int fromMonth, int toMonth) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void repeatedExpense(double amount, int fromMonth, int toMonth, String description) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MonthlyDto retrieveExpenses(int fromMonth, int toMonth) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addExtraAmount(double amount, int month, String description) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addLimit(double amount, int fromMonth, int toMonth) {
		// TODO Auto-generated method stub
		
	}



}
