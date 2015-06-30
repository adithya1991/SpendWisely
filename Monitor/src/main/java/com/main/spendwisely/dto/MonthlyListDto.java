package com.main.spendwisely.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;
@XmlRootElement(name="MonthlyListDto")
@XmlAccessorType(XmlAccessType.FIELD)
public class MonthlyListDto {
	@XmlElement(name="MonthData")
	List<MonthlyDto> monthlyDto;

	public List<MonthlyDto> getMonthlyDto() {
		return monthlyDto;
	}

	public void setMonthlyDto(List<MonthlyDto> monthlyDto) {
		this.monthlyDto = monthlyDto;
	} 
	
	
	
}
