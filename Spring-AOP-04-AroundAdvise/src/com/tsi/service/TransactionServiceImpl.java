package com.tsi.service;


import com.tsi.beans.Account;
import com.tsi.beans.Cheque;

public class TransactionServiceImpl implements TransactionService {

	@Override
	public void debit(Account acc, Cheque chque) {

		int initial_Balance = acc.getBalance();
		int debit_amount =chque.getAmount();
		int total_Amount = initial_Balance - debit_amount;
		acc.setBalance(total_Amount);
		System.out.println("**********Transaction Success****************");

	}

}
