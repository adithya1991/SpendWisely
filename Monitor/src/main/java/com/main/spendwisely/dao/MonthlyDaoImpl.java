package com.main.spendwisely.dao;

import java.util.ArrayList;
import java.util.List;

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

@Repository
public class MonthlyDaoImpl implements MonthlyDao,ApplicationContextAware{
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private ApplicationContext applicationContext;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public void addSalary(double amount, int fromMonth, int toMonth,
			int fromYear, int toYear) {
		for(int year = fromYear ; year <=toYear ; year ++)
		{
			for(int month = fromMonth ; month <= toMonth ; month ++)
			{
				// Check if record already exists for a particular month 
				MonthlyData monthlyData = getThisProxy(MonthlyDao.class).checkIfMonthRecExists(month, year);
				if(monthlyData == null)
				{
					// We need to create it for the first time
					monthlyData =  getThisProxy(MonthlyDao.class).addNewMonthlyRecord(year, 0, month);
				}
				monthlyData.setSalary(monthlyData.getSalary() + amount);
				monthlyData.setSaving(monthlyData.getSalary() - monthlyData.getExpense());
			}
		}
		
		
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public  MonthlyData checkIfMonthRecExists(int month,int year)
	{
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
		// DO nothing
	}
	return mon;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public MonthlyData addNewMonthlyRecord(int year,double amount,int month )
	{
		MonthlyData monthly = new MonthlyData();
		monthly.setYear(year);
		monthly.setExpense(amount);
		monthly.setMonthNo(month);
		monthly.setUserId("bleh");
		entityManager.persist(monthly);
		return monthly;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext = applicationContext;
	}
	
	
	

	@Transactional(propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	@Override
	public List<MonthlyData> getExpenses(int fromMonth, int toMonth,
			int fromYear, int toYear) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<MonthlyData> criteriaQuery = criteriaBuilder.createQuery(MonthlyData.class);
		Root<MonthlyData> root = criteriaQuery.from(MonthlyData.class);
		Predicate fromMonthPred = criteriaBuilder.greaterThanOrEqualTo(root.<Integer>get("monthNo"), fromMonth);
		Predicate toMonthPred = criteriaBuilder.lessThanOrEqualTo(root.<Integer>get("monthNo"), toMonth);
		Predicate fromYearPred = criteriaBuilder.greaterThanOrEqualTo(root.<Integer>get("year"), fromYear);
		Predicate toYearPred = criteriaBuilder.lessThanOrEqualTo(root.<Integer>get("year"), toYear);
		List<Predicate> predicateList = new ArrayList<Predicate>();
		predicateList.add(fromMonthPred);
		predicateList.add(toMonthPred);
		predicateList.add(fromYearPred);
		predicateList.add(toYearPred);
		Predicate[] predicateArray = new Predicate[predicateList.size()];
		predicateList.toArray(predicateArray);
		criteriaQuery.where(predicateArray);
		TypedQuery<MonthlyData> typedQuery = entityManager.createQuery(criteriaQuery);
		return typedQuery.getResultList();
			
	}
	
	public <T> T getThisProxy(Class<T> clazz)
	{
		return this.applicationContext.getBean(clazz);
	}
	
}
