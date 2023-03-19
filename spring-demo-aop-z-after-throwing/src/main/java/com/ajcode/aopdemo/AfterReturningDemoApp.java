package com.ajcode.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ajcode.aopdemo.dao.AccountDAO;
import com.ajcode.aopdemo.dao.MembershipDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		//get bean from spring container
		AccountDAO theAccountDAO = context.getBean("AddAccount", AccountDAO.class);
		
		
		List<Account> accounts= theAccountDAO.findAccounts(false);
		
		System.out.println("after returning");
		
		
		System.out.println(accounts);
		
		//close context
		context.close();
	}

}
