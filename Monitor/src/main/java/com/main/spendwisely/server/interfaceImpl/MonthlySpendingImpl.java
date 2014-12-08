package com.main.spendwisely.server.interfaceImpl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.main.spendwisely.dto.ErrorCodesType;
import com.main.spendwisely.dto.SpendWiselyException;
import com.main.spendwisely.server.interfaces.MonthlySpending;

@Service("MonthlySpending")
public class MonthlySpendingImpl implements MonthlySpending {

@Override
  public void addAmount(double amount, int fromMonth, int toMonth) {
    // Testing(throw exception which is caught by exception mapper;

    throw new SpendWiselyException("Yooo", ErrorCodesType.INTERNAL_ERROR.getErrorCode());

  }

@Override
public void repeatedExpense(double amount, int fromMonth, int toMonth,String body) {

	
	
}

@Override
public void retrieveExpenses(Date month) {
	
	
}

@Override
public void addExtraAmount(double amount, Date month) {
	// TODO Auto-generated method stub
	
}



}
