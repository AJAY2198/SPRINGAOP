package com.ajcode.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.ajcode.aopdemo.service.TrafficFortuneService;

public class AroundLoggerDemoApp {

	private static Logger logger = Logger.getLogger(AroundLoggerDemoApp.class.getName());
	
	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		//get bean from spring container
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		 logger.info("Start..");
		 
	     logger.info(trafficFortuneService.getFortune());	
			
	    logger.info("Finished");
		//close context
		context.close();
	}

}
