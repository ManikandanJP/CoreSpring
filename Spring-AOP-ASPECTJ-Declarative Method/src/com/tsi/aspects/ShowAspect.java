package com.tsi.aspects;

import org.aspectj.lang.ProceedingJoinPoint;

public class ShowAspect {

	public void before() {
		System.out.println("Get Tickets for Show :");
	}

	public void around(ProceedingJoinPoint pjp) {
		System.out.println("Show is ready to start. Take chairs and Keep your mobile phone is silent mode");
		try {
			pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("Show Completed just now. Check your lagugages");
	}

	public void after() {
		System.out.println("Show is over, Please leave the Hall");
	}

	public void afterReturning() {
		System.out.println("Thank you so much for attending our show!!.");
	}

	public void afterThrowing() {
		System.out.println(
				"There is an interruption in show, Because Show is not Mimicry Show. Please come to counter to collect your Amount");
	}
}
