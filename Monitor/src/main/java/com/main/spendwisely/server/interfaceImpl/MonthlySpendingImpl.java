package com.main.spendwisely.server.interfaceImpl;

import java.util.Date;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.spendwisely.dto.ErrorCodesType;
import com.main.spendwisely.dto.ErrorResponseType;
import com.main.spendwisely.dto.MonthlyDto;
import com.main.spendwisely.dto.ProcessingStatusType;
import com.main.spendwisely.dto.SpendWiselyException;
import com.main.spendwisely.dto.SpendWiselyResponse;
import com.main.spendwisely.server.interfaces.MonthlySpendingWebService;
import com.main.spendwisely.services.MonthlyService;


public class MonthlySpendingImpl implements MonthlySpendingWebService {
	
	@Autowired
	private MonthlyService monthlyService;

	@Override
	public SpendWiselyResponse<Object> addAmount(double amount, int fromMonth, int toMonth,int fromYear,int toYear) {
		// TODO Auto-generated method stub
		SpendWiselyResponse<Object> spendWiselyResponse = new SpendWiselyResponse<Object>();
		try
		{
			monthlyService.addSalary(amount, fromMonth, toMonth,fromYear,toYear);
			spendWiselyResponse.setGeneralProcessingStatus(ProcessingStatusType.OK);
		}
		catch(Exception e)
		{
			spendWiselyResponse.setGeneralProcessingStatus(ProcessingStatusType.ERROR);
			ErrorResponseType error = new ErrorResponseType();
			error.setErrorCode(1000);
			error.setErrorMessage(e.getMessage());
			spendWiselyResponse.setErrorResponse(error);
		}
		return spendWiselyResponse;
		}

	@Override
	public SpendWiselyResponse<Object> repeatedExpense(double amount, int fromMonth, int toMonth, String description) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MonthlyDto retrieveExpenses(int fromMonth, int toMonth) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SpendWiselyResponse<Object> addExtraAmount(double amount, int month, String description) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SpendWiselyResponse<Object> addLimit(double amount, int fromMonth, int toMonth) {
		// TODO Auto-generated method stub
		return null;
	}



}
