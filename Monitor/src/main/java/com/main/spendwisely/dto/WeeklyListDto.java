package com.main.spendwisely.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="WeeklyDatas")
public class WeeklyListDto {
	
	public List<WeeklyDto> weeklyListDto;

	public List<WeeklyDto> getWeeklyListDto() {
		return weeklyListDto;
	}

	public void setWeeklyListDto(List<WeeklyDto> weeklyListDto) {
		this.weeklyListDto = weeklyListDto;
	}
	
	
	

}
