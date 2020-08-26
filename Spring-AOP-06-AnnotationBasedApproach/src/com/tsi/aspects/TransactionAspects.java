package com.tsi.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.tsi.beans.Account;
import com.tsi.exceptions.InsufficientFundException;

@Component("aspect")
@Aspect
public class TransactionAspects {

	@Before("execution(* com.tsi.services.TransactionService.*(..))")
	public void before(JoinPoint jp) {
		Object[] params = jp.getArgs();
		Account acc = (Account) params[0];
		System.out.println("Before Advice Method : Initial Balance of your Account is  :" + acc.getBalance());

	}

	@After("execution(* com.tsi.services.TransactionService.*(..))")
	public void after(JoinPoint jp) {
		Object[] params = jp.getArgs();
		Account acc = (Account) params[0];
		System.out.println("After Advice Method : Final Balance of your Account is  :" + acc.getBalance());
	}

	@AfterReturning(pointcut = "execution(* com.tsi.services.TransactionService.*(..))",returning = "results")
	public void afterReturning(JoinPoint jp, String results) {

		System.out.println("Transaction Status " + results);

	}
	
    @Around("execution(* com.tsi.services.TransactionService.*(..))")
	public void around(ProceedingJoinPoint pjp) throws Throwable {

		System.out.println("Around Advice Before Method: " + pjp.getSignature().getName() + "Method Exception!!");
		String status = "";
		try {

			status = (String) pjp.proceed();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Around Advice After Method :" + pjp.getSignature().getName() + "Method Exception!!");
		System.out.println("Around Advice After Method : Transaction Status :" + status);

	}
    
    @AfterThrowing(pointcut ="execution(* com.tsi.services.TransactionService.*(..))",throwing = "exception" )

	public void afterThrowing(JoinPoint jp, InsufficientFundException exception) {

		System.out.println(
				"After Throwing  :" + exception.getClass().getName() + "In Transaction " + exception.getMessage());

	}

}
