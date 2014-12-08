package com.main.spendwisely.dto;

import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;
@XmlRootElement(name="MonthlyListDto")
public class MonthlyListDto {

	List<MonthlyDto> monthlyDto;

	public List<MonthlyDto> getMonthlyDto() {
		return monthlyDto;
	}

	public void setMonthlyDto(List<MonthlyDto> monthlyDto) {
		this.monthlyDto = monthlyDto;
	} 
	
	
	
}
