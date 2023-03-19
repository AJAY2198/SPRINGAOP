package com.ajcode.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyCloudLogAspect {

	
	@Before("com.ajcode.aopdemo.aspect.AjAopExpression.forDAOpackageExcludeGETSET()")
	public void logToCould() {
		System.out.println("\n=====> Logging to Cloud");
	}
}
