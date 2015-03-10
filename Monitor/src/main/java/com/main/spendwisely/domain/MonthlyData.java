package com.main.spendwisely.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MONTHLY_DATA")
public class MonthlyData extends AbstractMYBaseCommonEntity{

	@Basic
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SEQUENCE_ID",columnDefinition="NUMBER(10)")
	private Integer sequenceId;
	
	@Basic
	@Column(name="USER_ID",columnDefinition="VARCHAR2(20)")
	private String userId;
	
	@Column(name="AMOUNT_SPENT",columnDefinition="NUMBER(10,2)")
	private double expense;
	
	@Column(name="SALARY",columnDefinition="NUMBER(10,2)")
	@Basic
	private double salary;

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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
	
}
