package com.ajcode.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
   
	@Pointcut("execution(* com.ajcode.aopdemo.dao.*.*(..))")
	private void forDAOpackage() {}
	
	
	
	@Before("forDAOpackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====> Exceuting berfore @before advice on method");
	}
	@Before("forDAOpackage()")
	public void performanceAnalytics() {
		System.out.println("\n=====> Performance Analytics");
	}
}
