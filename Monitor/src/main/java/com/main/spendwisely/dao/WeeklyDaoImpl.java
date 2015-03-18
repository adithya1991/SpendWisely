package com.main.spendwisely.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.main.spendwisely.domain.MonthlyData;
import com.main.spendwisely.domain.WeeklyData;

@Repository
public class WeeklyDaoImpl implements WeeklyDao,ApplicationContextAware {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private MonthlyDao monthlyDao;
	
	private ApplicationContext applicationContext;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
	public void storeWeeklyExpense(double amount, String description, int week,
			int month,int year) {
		
		createNewWeeklyData(amount,description,week,month,year);
		
		// Also we need to get the correspnding month and update details 
		updateCorrespondingMonthlyData(amount,week,month,year);
		
	}
	
	
	
	
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	private void updateCorrespondingMonthlyData(double amount, int week, int month, int year) {
		// For this purpose we will try to use jpa 2 criteria queries 
					MonthlyData monthlyData = monthlyDao.checkIfMonthRecExists(month, year);
					// This is the case where we got to create a month for the very first time
					if(monthlyData == null)
					{
						monthlyData = monthlyDao.addNewMonthlyRecord(year, amount, month);
						monthlyData.setSaving(monthlyData.getSalary() - monthlyData.getExpense());
					return;
					}
					else
					{
						// Now we have the specific month , we need to add the expense and store it 
						monthlyData.setExpense(monthlyData.getExpense() + amount);
						// We also compute saving 
						if(monthlyData.getSalary() != 0)
						{
							monthlyData.setSaving(monthlyData.getSalary() - monthlyData.getExpense());
						}
						// Hibernate will automatically persist it at the end of the transaction
						
					}
				}
				
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	private void updateExistingWeeklyData(WeeklyData existingWeeklyData,double amount) {
		existingWeeklyData.setExpense(existingWeeklyData.getExpense() + amount);
		
	}

	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	private void createNewWeeklyData(double amount, String description,
			int week, int month, int year) {
		// here we need to persist the given entity 
				WeeklyData weeklyData = new WeeklyData();
				weeklyData.setDescription(description);
				weeklyData.setExpense(amount);
				weeklyData.setMonthNo(month);
				weeklyData.setWeekNo(week);
				weeklyData.setYear(year);
				weeklyData.setUserId("bleh");
				entityManager.persist(weeklyData);
		
	}


	@Transactional(propagation=Propagation.REQUIRED,rollbackFor = Exception.class)
	private WeeklyData checkIfCreateFlow(double amount, int week, int month,
			int year) {
		CriteriaBuilder checkingCriteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<WeeklyData> weeklyCriteriaCheck = checkingCriteriaBuilder.createQuery(WeeklyData.class);
		Root<WeeklyData> weeklyRoot = weeklyCriteriaCheck.from(WeeklyData.class);
		Predicate weekPred = checkingCriteriaBuilder.and(checkingCriteriaBuilder.equal(weeklyRoot.get("weekNo"),week),
				checkingCriteriaBuilder.equal(weeklyRoot.get("monthNo"),month),checkingCriteriaBuilder.equal(weeklyRoot.get("year"),year)
				,checkingCriteriaBuilder.equal(weeklyRoot.get("userId"),"bleh"));
		weeklyCriteriaCheck.where(weekPred);
		TypedQuery<WeeklyData> ty = entityManager.createQuery(weeklyCriteriaCheck);
		WeeklyData weekRes = null;
		try
		
		{
			weekRes = ty.getSingleResult();
		}
		catch(NoResultException nr)
		{
			// Do nothing as we will return anyways
		}
		return weekRes;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
		
	}

}
