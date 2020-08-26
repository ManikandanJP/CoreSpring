package com.tsi.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tsi.bean.Show;
import com.tsi.service.ShowService;

public class Test {

	public static void main(String[] args) {
     ApplicationContext context = new ClassPathXmlApplicationContext("/com/tsi/resource/applicationContext.xml");
     Show show = (Show) context.getBean("showBean");
     ShowService showService = (ShowService) context.getBean("showService");
         
     
     try {
		showService.runShow(show);
	} catch (Exception e) {
	   e.printStackTrace();
	}

	}

}
