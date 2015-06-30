package com.main.spendwisely.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.main.spendwisely.dao.WeeklyDao;
import com.main.spendwisely.domain.WeeklyData;
import com.main.spendwisely.dto.WeeklyDto;
import com.main.spendwisely.dto.WeeklyListDto;
import com.main.spendwisely.services.WeeklyService;

@Service("WeeklyService")
public class WeeklyServiceImpl implements WeeklyService{
	
	@Autowired
	private WeeklyDao weeklyDaoImpl;
	
	@Autowired
	private Mapper mapper;
	
	@Override
	public void storeWeekExpense(double amount, String description, int... wMo) {
		int week = wMo[0];
		int month = wMo[1];
		int year = wMo[2];
		
		weeklyDaoImpl.storeWeeklyExpense(amount,description,week,month,year );
		 
	}

	@Override
	public WeeklyListDto getWeeklyExpense(int fromWeek,int toWeek,int fromMonth, int toMonth) {
		List<WeeklyData> weeklyDatas = weeklyDaoImpl.retrieveAllExpenses(fromWeek, toWeek, fromMonth, toMonth);
		List<WeeklyDto> weeklyDtos = new ArrayList<WeeklyDto>();
		// Now we use dozer to map these onto the dto objects :D
		if(!CollectionUtils.isEmpty(weeklyDatas))
		{
			for(WeeklyData weeklyData : weeklyDatas)
			{
				WeeklyDto weeklyDto = mapper.map(weeklyData, WeeklyDto.class);
				weeklyDtos.add(weeklyDto);
			}
		}
		WeeklyListDto weeklyListDto = new WeeklyListDto();
		weeklyListDto.setWeeklyListDto(weeklyDtos);
		return weeklyListDto;
		
	}

}
