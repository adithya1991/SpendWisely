package com.main.spendwisely.server.interfaceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.main.spendwisely.domain.WeeklyData;
import com.main.spendwisely.dto.ErrorResponseType;
import com.main.spendwisely.dto.ProcessingStatusType;
import com.main.spendwisely.dto.SpendWiselyResponse;
import com.main.spendwisely.dto.WeeklyListDto;
import com.main.spendwisely.server.interfaces.WeeklySpendingWebService;
import com.main.spendwisely.services.WeeklyService;


public class WeeklySpendingImpl implements WeeklySpendingWebService{
	
	@Autowired
	private WeeklyService weeklyService;
	
	@Override
	public SpendWiselyResponse<Void> storeExpense(double amount, int month,int week,int year, String description) {
		// now we need to store all these details into the week table
		// and add it to the current total of the month as well 
		SpendWiselyResponse<Void> spendWiselyResponse = new SpendWiselyResponse<Void>();
		
		try
		{
		weeklyService.storeWeekExpense(amount, description, week,month,year);
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
	public WeeklyListDto retrieveExpenses(int fromWeek,int toWeek,int fromMonth, int toMonth) {
		return weeklyService.getWeeklyExpense(fromWeek, toWeek, fromMonth, toMonth);
	
	}

	

}
