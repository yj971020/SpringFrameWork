package com.springbook.biz.common;

//@Service
//@Aspect
public class LogAdvice {
//	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut() {}
	
//	@Pointcut("execution(* com.springbook.biz..*Impl.get*(..))")
	public void getPointcut() {}
	
//	//advice ������̼� : advice�� ���۽��� ������̼��� ����Ѵ�.
//	@Before("allPointcut()")
	public void printLog() {
		System.out.println("[���� �α�] ����Ͻ� ���� ���� �� ����");
	}
}
