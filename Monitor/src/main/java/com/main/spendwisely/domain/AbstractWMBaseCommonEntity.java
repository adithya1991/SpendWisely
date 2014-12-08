package com.main.spendwisely.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;


// This entity will have the common data associated with other entities
@Embeddable
public class AbstractWMBaseCommonEntity {
	@Column(columnDefinition="NUMBER(1,0)",name="WEEK_NO")
	@Basic
	Integer weekNo;
	
	@Column(columnDefinition="NUMBER(4,0)",name="YEAR_NO")
	@Basic
	Integer year;

	public Integer getWeekNo() {
		return weekNo;
	}

	public void setWeekNo(Integer weekNo) {
		this.weekNo = weekNo;
	}

	

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}
	
	

	
}
