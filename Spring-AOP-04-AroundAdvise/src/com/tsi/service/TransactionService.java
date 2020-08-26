package com.tsi.service;

import com.tsi.beans.Account;
import com.tsi.beans.Cheque;

public interface TransactionService {
	
	public void debit(Account acc, Cheque chque); 
}
