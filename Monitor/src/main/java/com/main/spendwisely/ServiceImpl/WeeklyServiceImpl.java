package com.main.spendwisely.ServiceImpl;

import org.springframework.stereotype.Service;

import com.main.spendwisely.dao.AbstractDao;
import com.main.spendwisely.factory.DaoEnum;
import com.main.spendwisely.factory.DaoFactory;
import com.main.spendwisely.services.WeeklyService;

@Service("WeeklyService")
public class WeeklyServiceImpl implements WeeklyService{

	@Override
	public void storeWeekExpense(double amount, String description, int... wMo) {
		int week = wMo[0];
		int month = wMo[1];
		int year = wMo[2];
		AbstractDao weeklyDao =  DaoFactory.getDao(DaoEnum.WEEKLY_DAO);
		weeklyDao.storeWeeklyExpense(amount,description,week,month,year );
		 
	}

}
