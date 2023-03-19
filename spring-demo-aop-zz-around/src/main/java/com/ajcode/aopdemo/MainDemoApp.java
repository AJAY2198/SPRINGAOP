package com.ajcode.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ajcode.aopdemo.dao.AccountDAO;
import com.ajcode.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		//get bean from spring container
		AccountDAO theAccountDAO = context.getBean("AddAccount", AccountDAO.class);
		

		//get bean from spring container
		MembershipDAO memebershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		
		//call business method
		theAccountDAO.addAccount(new Account(),true);
		theAccountDAO.doWork();
		theAccountDAO.setName("Ajay");
		System.out.println(theAccountDAO.getName());
		
//		memebershipDAO.addMemeber();
//		memebershipDAO.doWork();
		//close context
		context.close();
	}

}
