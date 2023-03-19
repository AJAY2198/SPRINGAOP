package com.ajcode.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.ajcode.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
   
	
	
	@Before("com.ajcode.aopdemo.aspect.AjAopExpression.forDAOpackageExcludeGETSET()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n=====> Exceuting berfore @before advice on method");
		
		//display method signature and args
		MethodSignature methoSig =  (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method : "+methoSig);
		
	}
	
	
	@AfterReturning(pointcut="execution(* com.ajcode.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterAddAccountAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		
		//display method signature and args
		String methoSig =  theJoinPoint.getSignature().toShortString();

		
		System.out.println("\n=====> Exceuting  @afterreturning advice on method" +methoSig);
		
		
		System.out.println("Result : "+result);
		
		convertNamesToUpperCase(result);
		
	}


	private void convertNamesToUpperCase(List<Account> result) {
		 
		result.forEach(n-> n.setName( n.getName().toUpperCase()));
		
	}
	
	
	
}
