package com.main.spendwisely.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RepeatativeEntries extends AbstractMYBaseCommonEntity{
	
	@Basic
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SEQUENCE_ID",columnDefinition="NUMBER(10)")
	private Integer sequenceId;
	
	@Basic
	@Column(name="USER_ID",columnDefinition="VARCHAR2(20)")
	private String userId;
	
	@Column(name="AMOUNT",columnDefinition="NUMBER(10,2)")
	private double expense;
	
	@Column(name="DESCRIPTION",columnDefinition="VARCHAR2(50)")
	@Basic
	private String description;

	public Integer getSequenceId() {
		return sequenceId;
	}

	public void setSequenceId(Integer sequenceId) {
		this.sequenceId = sequenceId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public double getExpense() {
		return expense;
	}

	public void setExpense(double expense) {
		this.expense = expense;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
