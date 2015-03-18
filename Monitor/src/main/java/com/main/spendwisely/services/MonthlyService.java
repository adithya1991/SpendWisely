package com.main.spendwisely.services;

import javax.ws.rs.QueryParam;

public interface MonthlyService {

	
	public void addSalary(double amount,int fromMonth,int toMonth,int fromYear,int toYear);
}
