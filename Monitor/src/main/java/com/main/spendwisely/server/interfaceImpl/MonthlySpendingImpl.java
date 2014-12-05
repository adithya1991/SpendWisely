package com.main.spendwisely.server.interfaceImpl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.main.spendwisely.dto.ErrorCodesType;
import com.main.spendwisely.dto.SpendWiselyException;
import com.main.spendwisely.server.interfaces.MonthlySpending;

@Service("MonthlySpending")
public class MonthlySpendingImpl implements MonthlySpending {

  public void addAmount(double amount, Date from, Date to) {
    // Testing(throw exception which is caught by exception mapper;

    throw new SpendWiselyException("Yooo", ErrorCodesType.INTERNAL_ERROR.getErrorCode());

  }

}
