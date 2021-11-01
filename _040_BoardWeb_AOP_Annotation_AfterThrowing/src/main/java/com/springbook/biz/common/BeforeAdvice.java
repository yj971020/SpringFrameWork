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
		
		System.out.println("[���� ó��] " + method + "() �޼ҵ� ARGS ���� : " + args[0].toString());
	}
}