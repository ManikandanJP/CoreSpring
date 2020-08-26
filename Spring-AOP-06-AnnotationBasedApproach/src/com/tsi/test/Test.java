package com.tsi.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tsi.beans.Account;
import com.tsi.services.TransactionService;

public class Test {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("/com/tsi/resources/applicationContext.xml");
		Account acc = (Account) context.getBean("accBean");
		TransactionService txnService = (TransactionService) context.getBean("transaction");
		try {
			txnService.withDraw(acc, 1000);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
