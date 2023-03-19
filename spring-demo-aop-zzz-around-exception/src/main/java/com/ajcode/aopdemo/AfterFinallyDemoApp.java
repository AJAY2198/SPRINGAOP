package com.ajcode.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ajcode.aopdemo.dao.AccountDAO;
import com.ajcode.aopdemo.dao.MembershipDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		//get bean from spring container
				AccountDAO theAccountDAO = context.getBean("AddAccount", AccountDAO.class);
				
				List<Account> accounts =null;

		try {
	               accounts= theAccountDAO.findAccounts(true);
				
		}catch(Exception exc) {
			System.out.println("\n main program cought exception :"+ exc);
			//exc.printStackTrace();
		}
		
		
		
		System.out.println("after throwing");
		
		
		System.out.println(accounts);
		
		//close context
		context.close();
	}

}
