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
	
	
	@Pointcut("execution(* com.ajcode.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	
	@Pointcut("execution(* com.ajcode.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	//create point: include package ..exclude getter/setter
	@Pointcut("forDAOpackage() && !(getter() || setter())")
	private void forDAOpackageExcludeGETSET() {}
	
	@Before("forDAOpackageExcludeGETSET()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====> Exceuting berfore @before advice on method");
	}
	@Before("forDAOpackageExcludeGETSET()")
	public void performanceAnalytics() {
		System.out.println("\n=====> Performance Analytics");
	}
}
