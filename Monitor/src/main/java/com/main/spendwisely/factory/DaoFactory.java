package com.main.spendwisely.factory;

import org.springframework.beans.factory.annotation.Autowired;

import com.main.spendwisely.dao.AbstractDao;
import com.main.spendwisely.dao.MonthlyDaoImpl;
import com.main.spendwisely.dao.WeeklyDaoImpl;

public class DaoFactory{
	@Autowired
	private static MonthlyDaoImpl monthlyDaoImpl;
	@Autowired
	private static WeeklyDaoImpl weeklyDaoImpl;
	
	
	public static AbstractDao getDao(DaoEnum daoName) {
		if(daoName.equals(DaoEnum.WEEKLY_DAO))
		{
			AbstractDao abstractDao =  weeklyDaoImpl;
			return abstractDao;
		}
		else if (daoName.equals(DaoEnum.MONTHLY_DAO))
		{
			AbstractDao abstractDao = monthlyDaoImpl;
			return abstractDao;
		}
		return null ;
		
	}
	
	
	
	

}
