package com.ajcode.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.ajcode.aopdemo.Account;
import com.ajcode.aopdemo.AroundLoggerDemoApp;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	private static Logger logger = Logger.getLogger(MyDemoLoggingAspect.class.getName());
	
	
	@Before("com.ajcode.aopdemo.aspect.AjAopExpression.forDAOpackageExcludeGETSET()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		logger.info("\n=====> Exceuting berfore @before advice on method");
		
		//display method signature and args
		MethodSignature methoSig =  (MethodSignature) theJoinPoint.getSignature();
		
		logger.info("Method : "+methoSig);
		
	}
	
	
	@AfterReturning(pointcut="execution(* com.ajcode.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterAddAccountAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		
		//display method signature and args
		String methoSig =  theJoinPoint.getSignature().toShortString();

		
		logger.info("\n=====> Exceuting  @afterreturning advice on method" +methoSig);
		
		
		logger.info("Result : "+result);
		
		convertNamesToUpperCase(result);
		
	}


	private void convertNamesToUpperCase(List<Account> result) {
		 
		result.forEach(n-> n.setName( n.getName().toUpperCase()));
		
	}
	
	@After("execution(* com.ajcode.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		//display method signature and args
	    String methoSig =  theJoinPoint.getSignature().toShortString();
	    
	    logger.info("\n=====> Exceuting @afterFinally advice on method " +methoSig);
				
	   

	}
	
	@AfterThrowing(pointcut="execution(* com.ajcode.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterTrhrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		//display method signature and args
	    String methoSig =  theJoinPoint.getSignature().toShortString();
	    
	    logger.info("\n=====> Exceuting @afterThrowing advice on method " +methoSig);
				
	    logger.info("\n=====> The Exceptin is: " +theExc);		

	}
	
	@Around("execution(* com.ajcode.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		//display method signature and args
	    String methoSig =  proceedingJoinPoint.getSignature().toShortString();
	    
	    logger.info("\n=====> Exceuting @Around advice on method " +methoSig);
	    
	    
	    long begin = System.currentTimeMillis();
	    
	    Object result = proceedingJoinPoint.proceed();
	    
	    long end = System.currentTimeMillis();
	    
	    long duration = end - begin;
	    
	    logger.info("Duration takes: "+ duration/1000);
		
		return result;
	}
	
	
	
	
	
	
	
}
