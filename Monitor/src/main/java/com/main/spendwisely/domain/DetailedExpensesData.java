package com.main.spendwisely.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity(name="WEEKLY_DATA")
public class DetailedExpensesData{
	@Basic
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SEQUENCE_ID",columnDefinition="NUMBER(10)")
	private Integer sequenceId;
	
	@Embedded
	private AbstractWMYBaseCommonEntity abstractWMYBaseCommonEntity;
	
	@Basic
	@Column(name="USER_ID",columnDefinition="VARCHAR2(20)")
	private String userId;
	
	@Column(name="EXPENSE",columnDefinition="NUMBER(10,2)")
	private double expense;
	
	@Column(name="DESCRIPTION",columnDefinition="VARCHAR2(50)")
	@Basic
	private String description;
	
	@Temporal(TemporalType.DATE)
	@Column(name="LAST_UPDATED",columnDefinition="datetime")
	private Date lastUpdateDateTime;

	public Integer getSequenceId() {
		return sequenceId;
	}

	public void setSequenceId(Integer sequenceId) {
		this.sequenceId = sequenceId;
	}

	public AbstractWMYBaseCommonEntity getAbstractWMYBaseCommonEntity() {
		return abstractWMYBaseCommonEntity;
	}

	public void setAbstractWMYBaseCommonEntity(AbstractWMYBaseCommonEntity abstractWMYBaseCommonEntity) {
		this.abstractWMYBaseCommonEntity = abstractWMYBaseCommonEntity;
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

	public Date getLastUpdateDateTime() {
		return lastUpdateDateTime;
	}

	public void setLastUpdateDateTime(Date lastUpdateDateTime) {
		this.lastUpdateDateTime = lastUpdateDateTime;
	}
	
	// Listener to update last time
	@PrePersist
	@PreUpdate
	public void updateLastUpdated()
	{
		this.setLastUpdateDateTime(new Date());
	}
	
	
}
