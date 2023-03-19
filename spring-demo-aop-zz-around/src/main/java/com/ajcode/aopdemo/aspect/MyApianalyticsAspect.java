package com.ajcode.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyApianalyticsAspect {
	
	
	@Before("com.ajcode.aopdemo.aspect.AjAopExpression.forDAOpackageExcludeGETSET()")
	public void performanceAnalytics() {
		System.out.println("\n=====> Performance Analytics");
	}

}
