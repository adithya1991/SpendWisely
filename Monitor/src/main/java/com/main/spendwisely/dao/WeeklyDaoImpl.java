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
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.main.spendwisely.domain.MonthlyData;
import com.main.spendwisely.domain.WeeklyData;

@Service
public class WeeklyDaoImpl implements WeeklyDao,ApplicationContextAware {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private ApplicationContext applicationContext;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
	public void storeWeeklyExpense(double amount, String description, int week,
			int month,int year) {
		
		// Here we need to check whether we need an update or a create 
		WeeklyData existingWeeklyData = checkIfCreateFlow(amount,week,month,year);
		
		// If null then we create a new weeklydata and persist it , else we will update the retrieved Entity
		if(existingWeeklyData == null)
		{
			createNewWeeklyData(amount,description,week,month,year);
		}
		else
		{
			updateExistingWeeklyData(existingWeeklyData,amount);
		}
		
		
		// Also we need to get the correspnding month and update details 
		updateCorrespondingMonthlyData(amount,week,month,year);
		
	}
	
	
	
	
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	private void updateCorrespondingMonthlyData(double amount, int week, int month, int year) {
		// For this purpose we will try to use jpa 2 criteria queries 
				CriteriaBuilder cb = entityManager.getCriteriaBuilder();
				CriteriaQuery<MonthlyData> criteriaMonthly = cb.createQuery(MonthlyData.class);
				// Now we need to specify what the actual query is about
				Root<MonthlyData> monthlyRoot = criteriaMonthly.from(MonthlyData.class);
				criteriaMonthly.select(monthlyRoot);
				Predicate userName = cb.equal(monthlyRoot.get("userId"),"bleh");
				Predicate monthPred = cb.equal(monthlyRoot.get("monthNo"),month);
				Predicate yearPred = cb.equal(monthlyRoot.get("year"),year);
				criteriaMonthly.where(userName,monthPred,yearPred);
				TypedQuery<MonthlyData> ty = entityManager.createQuery(criteriaMonthly);
				MonthlyData mon = null;
				try
				{
				mon = ty.getSingleResult();
				}
				catch(NoResultException nr)
				{
					// This is the case where we got to create a month for the very first time
					MonthlyData monthly = new MonthlyData();
					monthly.setYear(year);
					monthly.setExpense(amount);
					monthly.setMonthNo(month);
					monthly.setUserId("bleh");
					entityManager.persist(monthly);
					return;
				}
				// Now we have the specific month , we need to add the expense and store it 
				mon.setExpense(mon.getExpense() + amount);
				// Hibernate will automatically persist it at the end of the transaction 
		
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
