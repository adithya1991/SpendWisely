package com.main.spendwisely.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Component;

import com.main.spendwisely.domain.MonthlyData;
import com.main.spendwisely.domain.WeeklyData;

@Component
public class WeeklyDaoImpl implements AbstractDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value=TxType.REQUIRES_NEW,rollbackOn = Exception.class)
	public void storeWeeklyExpense(double amount, String description, int week,
			int month,int year) {
		// here we need to persist the given entity 
		WeeklyData weeklyData = new WeeklyData();
		weeklyData.setDescription(description);
		weeklyData.setExpense(amount);
		weeklyData.setMonthNo(month);
		weeklyData.setWeekNo(week);
		weeklyData.setYear(year);
		entityManager.persist(weeklyData);
		
		// Also we need to get the correspnding month and update details 
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
		MonthlyData mon = ty.getSingleResult();
		// Now we have the specific month , we need to add the expense and store it 
		mon.setExpense(mon.getExpense() + amount);
		// Hibernate will automatically persist it at the end of the transaction 
		
		
	}

}
