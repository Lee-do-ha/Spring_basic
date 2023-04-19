package com.ssafy.aop.step04.after.throwing;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ExceptionAdvice {

	@AfterThrowing(pointcut = "execution(public * com.ssafy.board..*Dao.*(..))", throwing = "ex")
	public void exceptionAfter(Exception ex){
		System.out.println("ExceptionAdvice :: " + ex.getMessage());
		ex.printStackTrace();
	}
	
}
