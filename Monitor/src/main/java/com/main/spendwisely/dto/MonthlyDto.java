package com.main.spendwisely.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="MonthlyData")
public class MonthlyDto {

	@XmlElement(name="month")
	Integer monthNo;
	@XmlElement(name="year")
	Integer year;
	@XmlElement(name="expense")
	double expense;
	@XmlElement(name="limit")
	double limit;
	@XmlElement(name="savings")
	double savings;
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
	public double getLimit() {
		return limit;
	}
	public void setLimit(double limit) {
		this.limit = limit;
	}
	public double getSavings() {
		return savings;
	}
	public void setSavings(double savings) {
		this.savings = savings;
	}
	
	
}
