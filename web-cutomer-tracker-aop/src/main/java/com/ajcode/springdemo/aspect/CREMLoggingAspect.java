package com.ajcode.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CREMLoggingAspect {
  
	private Logger logger = Logger.getLogger(CREMLoggingAspect.class.getName());
	
	@Pointcut("execution(* com.ajcode.springdemo.controller.*.*(..))")
	private void forControllerPacakge() {}
	
	@Pointcut("execution(* com.ajcode.springdemo.service.*.*(..))")
	private void forServicePacakge() {}
	
	@Pointcut("execution(* com.ajcode.springdemo.dao.*.*(..))")
	private void forDAOPacakge() {}
	
	@Pointcut("forControllerPacakge() || forServicePacakge() || forDAOPacakge()")
	private void AppFlow() {}
	
	
	@Before("AppFlow()")
	public void before(JoinPoint joinPoint) {
		
		String method = joinPoint.getSignature().toShortString();
		
		logger.info("===> in @Before calling method "+method);
	
		Object[] args = joinPoint.getArgs();
		
		for(Object obj : args) {
			logger.info("===> argument: "+ obj);
		}
		logger.info("===> in @Before calling method "+method);
	
	}
	
	//after returning
	@AfterReturning(pointcut="AppFlow()",
			returning="result")
	public void afterReturing(JoinPoint joinPoint, Object result) {
        String method = joinPoint.getSignature().toShortString();
		
		logger.info("===> in @AfterReturning calling method "+method);
		
		logger.info("===> result: "+ result);
		
	}
	
	
}
