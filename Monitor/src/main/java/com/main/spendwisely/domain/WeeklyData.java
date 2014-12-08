package com.main.spendwisely.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WeeklyData {
	
	@Basic
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SEQUENCE_ID",columnDefinition="NUMBER(10)")
	private Integer sequenceId;
	
	@Embedded
	private AbstractWMBaseCommonEntity abstractWMBaseCommonEntity;
	
	@Basic
	@Column(name="USER_ID",columnDefinition="VARCHAR2(20)")
	private String userId;
	
	@Column(name="EXPENSE",columnDefinition="NUMBER(10,2)")
	private double expense;
	
	@Column(name="DESCRIPTION",columnDefinition="VARCHAR2(50)")
	@Basic
	private String description;

}
