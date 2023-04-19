package com.ssafy.aop.step05.after;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class CountAdvice {

	@After("execution(public * com.ssafy.board..*Dao.*(..))")
	public void after(JoinPoint joinPoint) {
		String name = joinPoint.toShortString();
		System.out.println("CountAdvice : " + name);
	}
	
}
