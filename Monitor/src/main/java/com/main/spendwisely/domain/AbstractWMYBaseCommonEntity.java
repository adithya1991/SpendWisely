package com.main.spendwisely.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;


// This entity will have the common data associated with other entities
@MappedSuperclass
public class AbstractWMYBaseCommonEntity {
	@Column(columnDefinition="NUMBER(1,0)",name="WEEK_NO")
	@Basic
	Integer weekNo;
	@Column(columnDefinition="NUMBER(2,0)",name="MONTH_NO")
	@Basic
	Integer monthNo;
	@Column(columnDefinition="NUMBER(4,0)",name="YEAR_NO")
	@Basic
	Integer year;

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
	
	

	
}
