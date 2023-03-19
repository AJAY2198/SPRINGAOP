package com.ajcode.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
   
	
	
	@Before("com.ajcode.aopdemo.aspect.AjAopExpression.forDAOpackageExcludeGETSET()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====> Exceuting berfore @before advice on method");
	}
	
	
	
}
