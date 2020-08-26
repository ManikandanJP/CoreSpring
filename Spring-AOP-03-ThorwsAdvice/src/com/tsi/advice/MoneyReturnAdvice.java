package com.tsi.advice;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class MoneyReturnAdvice implements ThrowsAdvice {

	public void afterThrowing(Method method, Object[] param, Object target, Exception e) {
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("Power Failure Occured, Moview Was Stopped, Please come to Counter and Collect Your Money");
		System.out.println("-----------------------------------------------------------------------------------------");

	}

}
