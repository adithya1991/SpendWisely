package com.main.spendwisely.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="WeeklyData")
@XmlAccessorType(XmlAccessType.FIELD)
public class WeeklyDto {
	@XmlElement(name="week")
	Integer weekNo;
	@XmlElement(name="month")
	Integer monthNo;
	@XmlElement(name="year")
	Integer year;
	@XmlElement(name="expense")
	double expense;
	public Integer getWeekNo() {
		return weekNo;
	}
	public void setWeekNo(Integer weekNo) {
		this.weekNo = weekNo;
	}
	public Integer getMonthNo() {
		return monthNo;
	}
	public void setMonthNo(Integer monthNo) {
		this.monthNo = monthNo;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public double getExpense() {
		return expense;
	}
	public void setExpense(double expense) {
		this.expense = expense;
	}
	
	
	
	
	
	
	

}
