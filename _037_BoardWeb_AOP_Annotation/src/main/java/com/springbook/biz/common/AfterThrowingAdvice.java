package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice {
	public void afterThrowingAdvice(JoinPoint jp, Exception exceptionObj) {
		String method = jp.getSignature().getName();
		
		System.out.println("[���� ó��] " + method + "() �޼ҵ� ���� �� �߻��� ���� �޽��� : " + exceptionObj.getMessage());
	}
}
