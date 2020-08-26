package com.tsi.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tsi.beans.Account;
import com.tsi.beans.Cheque;
import com.tsi.service.TransactionService;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/tsi/resource/applicationContext.xml");
		Account acc = (Account) context.getBean("accBean");
		Cheque cheque = (Cheque) context.getBean("chequeBean");
		TransactionService txn_service = (TransactionService) context.getBean("proxy");
		txn_service.debit(acc, cheque);
	}

}
