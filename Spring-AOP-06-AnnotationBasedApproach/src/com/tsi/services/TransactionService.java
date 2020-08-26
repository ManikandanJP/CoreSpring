package com.tsi.services;

import com.tsi.beans.Account;
import com.tsi.exceptions.InsufficientFundException;

public interface TransactionService {
	
	public String withDraw(Account acc, int with_draw_amount) throws InsufficientFundException;

}
