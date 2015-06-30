package com.main.spendwisely.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name="WeeklyDatas")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class WeeklyListDto {
	
	public List<WeeklyDto> weeklyListDto;
	@XmlElement(name="WeeklyData")
	public List<WeeklyDto> getWeeklyListDto() {
		return weeklyListDto;
	}

	public void setWeeklyListDto(List<WeeklyDto> weeklyListDto) {
		this.weeklyListDto = weeklyListDto;
	}
	
	
	

}
