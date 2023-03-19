package com.ajcode.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;



@Aspect
public class AjAopExpression {

	@Pointcut("execution(* com.ajcode.aopdemo.dao.*.*(..))")
	public void forDAOpackage() {}
	
	
	@Pointcut("execution(* com.ajcode.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	
	@Pointcut("execution(* com.ajcode.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	//create point: include package ..exclude getter/setter
	@Pointcut("forDAOpackage() && !(getter() || setter())")
	public void forDAOpackageExcludeGETSET() {}
	
}
