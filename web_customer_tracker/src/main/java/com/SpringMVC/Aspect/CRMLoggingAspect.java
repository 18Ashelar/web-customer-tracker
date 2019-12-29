package com.SpringMVC.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	//setup Logger
	private Logger myLogger=Logger.getLogger(getClass().getName());
	
	//setup pointcut declaration

	@Pointcut("execution(* com.SpringMVC.Service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.SpringMVC.Dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut(" forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	
	//add @Before Advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint)
	{
		String theMethod=theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>> in @Before: calling nethod: "+theMethod);
		
		// get the arguments
				Object[] args = theJoinPoint.getArgs();
				
				// loop thru and display args
				for (Object tempArg : args) {
					myLogger.info("=====>> argument: " + tempArg);
				}
	}
	
	//add @AfterReturning advice
	// add @AfterReturning advice
		@AfterReturning(
				pointcut="forAppFlow()",
				returning="theResult"
				)
		public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
			// display method we are returning from
			String theMethod = theJoinPoint.getSignature().toShortString();
			myLogger.info("=====>> in @AfterReturning: from method: " + theMethod);
					
			// display data returned
			myLogger.info("=====>> result: " + theResult);
		
		}
	
	
	

}
