package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;

//@Service
//@Aspect
public class BeforeAdvice {
//	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut() {}
	
//	@Before("allPointcut()")
	public void beforeAdvice(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		System.out.println("[사전 처리] " + method + "() 메소드 ARGS 정보 : " + args[0].toString());
	}
}