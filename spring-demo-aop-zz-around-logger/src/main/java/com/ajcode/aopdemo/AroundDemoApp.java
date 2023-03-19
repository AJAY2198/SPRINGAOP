package com.ajcode.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ajcode.aopdemo.dao.AccountDAO;
import com.ajcode.aopdemo.dao.MembershipDAO;
import com.ajcode.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		//get bean from spring container
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		 System.out.println("Start..");
		 
	     System.out.println(trafficFortuneService.getFortune());	
			
	     System.out.println("Finished");
		//close context
		context.close();
	}

}
