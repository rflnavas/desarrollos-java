package com.rnr.springtutorial.beans;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
	
	@Before("execution(com.rnr.springtutorial.servlets.LoggerServletListener.requestInitialized (ServletRequestEvent))")
	//@Pointcut("within(com.rnr.springtutorial.servlets..*)")
	public void doGet(ProceedingJoinPoint pjp){
		System.out.println("Before doGet on " + pjp.getSourceLocation().toString());
	}
	
	@Before("execution(com.rnr.springtutorial.servlets.*.*(..))")
	public void doPost(){//ProceedingJoinPoint pjp
		System.out.println("AAAAAAAAAAAA");
		//System.out.println("Before doGet on " + pjp.getSourceLocation().toString());
	}
	
}
