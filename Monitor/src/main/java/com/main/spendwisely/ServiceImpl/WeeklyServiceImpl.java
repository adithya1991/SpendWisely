package com.main.spendwisely.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.spendwisely.dao.WeeklyDao;
import com.main.spendwisely.services.WeeklyService;

@Service("WeeklyService")
public class WeeklyServiceImpl implements WeeklyService{
	
	@Autowired
	private WeeklyDao weeklyDaoImpl;
	
	@Override
	public void storeWeekExpense(double amount, String description, int... wMo) {
		int week = wMo[0];
		int month = wMo[1];
		int year = wMo[2];
		
		weeklyDaoImpl.storeWeeklyExpense(amount,description,week,month,year );
		 
	}

}
