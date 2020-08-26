package com.tsi.services;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.tsi.beans.Account;
import com.tsi.exceptions.InsufficientFundException;

@Component("transaction")
public class TransactionServiceImpl implements TransactionService {

	@Override
	public String withDraw(Account acc, int with_draw_amount) throws InsufficientFundException {
        String status="";
        if (acc.getBalance() > with_draw_amount) {
        	int total_Balance = acc.getBalance() - with_draw_amount;
        	acc.setBalance(total_Balance);
            System.out.println("From WithDraw() Business Method : Transaction WithDraw Completed");        	
            status="Sucess";
        } else {
        	status = "Failure";
        	throw new InsufficientFundException("InsufficientFundException");
        }
        
		return status;
	}

}
