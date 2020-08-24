package com.tsi.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tsi.dao.EmployeeDAO;
import com.tsi.dto.Employee;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     ApplicationContext context = new ClassPathXmlApplicationContext("com/tsi/resources/applicationContext.xml");
     EmployeeDAO emp = (EmployeeDAO) context.getBean("employeeDao");

     
     Employee emp1  = new Employee();
     emp1.setEno(111);
     emp1.setEname("Shiwin");
     emp1.setEsal(100000);
     emp1.setEaddr("MAA");
     String status = emp.Add(emp1);
     System.out.println(status);
     
      status = emp.delete(222);
     System.out.println(status);
     
     emp1 = new Employee();
     emp1.setEno(111);
     emp1.setEname("Divya");
     emp1.setEsal(18000);
     emp1.setEaddr("AKL");
     status = emp.update(emp1);
     System.out.println(status);
    
     
     
    		 
	}

}
