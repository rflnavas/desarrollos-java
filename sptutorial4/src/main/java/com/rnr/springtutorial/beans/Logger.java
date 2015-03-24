package com.rnr.springtutorial.beans;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
	
	public static int hits = 0;
	
	public void logGun(){
		System.out.println("Gun has been used!");
	}
	
	public void chargingSpecialBullet(){
		System.out.println("Reloading gun with special bullets");
	}
	
	@Before("execution(void com.rnr.springtutorial.beans.Gun.shoot(..))")
	public void aboutToShoot() {
		System.out.println("About to shoot...");
	}
	
	public void shot(){
		System.out.println("--->");
	}
	
	@AfterThrowing("execution(void com.rnr.springtutorial.beans.*.*())")
	public void error(){
		System.err.println("An exception has been raised ...");
	}
	
	@AfterReturning("execution(void com.rnr.springtutorial.beans.Gun.setZoom(..))")
	public void afterReturnSetZoom(){
		System.out.println("zoom set");
	}
	
	@Around("execution(void com.rnr.springtutorial.beans.Gun.reload())")
	public void aroundAdvice(ProceedingJoinPoint p){
		System.out.println("around : Gun.reload() - before");
		
		try {
			p.proceed();
		} catch (Throwable e) {
			System.err.println("around : Gun.reload(): THROWABLE");
		}
		
		System.out.println("around : Gun.reload() - after");
	}
	//The within operator allows you to be more generic 
	@Pointcut("within(com.rnr.springtutorial..*)")
	public void logWithin(){
	}
	
	@After("logWithin()")
	public void logWithinAdvice(){
		System.out.println("logWithinAdvice - registered");
	}
	//Target is more especific tan within. Additionally, we can't use wildcards
	@Pointcut("target(com.rnr.springtutorial.beans.Unit)")
	public void logTarget(){
	}
	
	@After("logTarget()")
	public void logTargetAdvice(){
		System.out.println("logAdviceTargetAdvice - registered");
	}
	
	//Target is more especific tan within. Additionally, we can't use wildcards
	@Pointcut("this(com.rnr.springtutorial.beans.Gun)")
	public void logThis(){
	}
	
	@After("logThis()")
	public void logThisAdvice(){
		System.out.println("logThisAdvice - registered");
	}
	
	@Pointcut("within(com.rnr.springtutorial..*)")
	public void increaseHit(){
		
	}
	@Before("increaseHit()")
	public void increaseHitAdvice(){
		hits++;
		System.out.println("hits new value is " + hits);
	}
}
