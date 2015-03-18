package com.main.spendwisely.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.spendwisely.dao.MonthlyDao;
import com.main.spendwisely.services.MonthlyService;

@Service
public class MonthlySpendingServiceImpl implements MonthlyService{
	
	@Autowired
	private MonthlyDao monthlyDao;

	@Override
	public void addSalary(double amount, int fromMonth, int toMonth,int fromYear,int toYear) {
		// Here we set the salary for a particular month of the year/ Range
			monthlyDao.addSalary(amount, fromMonth, toMonth, fromYear, toYear);
		
	}

}
