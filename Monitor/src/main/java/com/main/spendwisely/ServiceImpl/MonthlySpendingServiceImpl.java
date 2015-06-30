package com.main.spendwisely.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.main.spendwisely.dao.MonthlyDao;
import com.main.spendwisely.domain.MonthlyData;
import com.main.spendwisely.dto.MonthlyDto;
import com.main.spendwisely.dto.MonthlyListDto;
import com.main.spendwisely.services.MonthlyService;

@Service
public class MonthlySpendingServiceImpl implements MonthlyService{
	
	@Autowired
	private MonthlyDao monthlyDao;
	
	@Autowired
	private Mapper mapper;

	@Override
	public void addSalary(double amount, int fromMonth, int toMonth,int fromYear,int toYear) {
		// Here we set the salary for a particular month of the year/ Range
			monthlyDao.addSalary(amount, fromMonth, toMonth, fromYear, toYear);
		
	}

	@Override
	public MonthlyListDto retrieveExpenses(int fromMonth, int toMonth, int fromYear,
			int toYear) {
			List<MonthlyData> list = monthlyDao.getExpenses(fromMonth,toMonth,fromYear,toYear);
			List<MonthlyDto> monthlyDtoList = new ArrayList<MonthlyDto>();
			
			if(!CollectionUtils.isEmpty(list))
			{
				for(MonthlyData monthlyData : list)
				{
				MonthlyDto monthlyDto = mapper.map(monthlyData, MonthlyDto.class);
				if(monthlyDto != null)
				{
					monthlyDtoList.add(monthlyDto);
				}
			}
			}
			MonthlyListDto monthlyListDto = new MonthlyListDto();
			monthlyListDto.setMonthlyDto(monthlyDtoList);
		return monthlyListDto;
	}
	
	

}
