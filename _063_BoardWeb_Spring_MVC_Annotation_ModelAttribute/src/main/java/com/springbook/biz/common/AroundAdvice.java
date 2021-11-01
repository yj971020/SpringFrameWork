package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AroundAdvice {
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut() {}
	//ProceedingJoinPoint : ���� �������� ����Ʈ�� �޼ҵ�
	//						JoinPoint�� ��ӹ޾Ƽ� �߰��� procced��� �޼ҵ带 ������ ��ü
	//						proceed() : ������ �޼ҵ带 �����ϴ� �޼ҵ�
	/*JoinPoint�� ������ �޼ҵ��
	*	getSignature() : ȣ��� ����Ͻ��� �޼ҵ��� �ñ״�ó(����Ÿ��, �̸�, �Ű�����)�� Signature ��ü�� ��Ƽ� ����
	*	getTarget() : ȣ��� ����Ͻ� �޼ҵ忡 �����ϴ� ����Ͻ� ��ü�� ����(insertBoard ȣ�� �� BoardServiceImpl ��ü ����)
	*	getArgs() : ȣ��� ����Ͻ� �޼ҵ��� �Ű����� ������ Object �迭�� ����
	* aop:before, after-returning, after-throwing, after : JoinPoint �������̽� �������
	* aop:around : ProceedingJoinPoint ��ü�� ����ؾ� ��
	*
	*getSignature() -> Signater��ü ���� �� Signature ��ü���� ��밡���� �޼ҵ�
	*	getName() : ȣ��� ����Ʈ�� �޼ҵ��� �޼ҵ�� StringŸ������ ����
	*	toLongString() : ȣ��� ����Ʈ�� �޼ҵ��� ����Ÿ��, �̸�, �Ű������� ��Ű����α��� ������ String Ÿ������ ����
	*	toShortString() : ȣ��� ����Ʈ�� �޼ҵ��� ����Ÿ��, �̸�, �Ű������� ����ؼ� String Ÿ������ ����
	*
	*/
	@Around("allPointcut()")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("[BEFORE] : ����Ͻ� ���� ���� �� ó���� ����...");
		Object returnObj = pjp.proceed();
		System.out.println("[AFTER] : ����Ͻ� ���� ���� �� ó���� ����...");
		return returnObj;
	}
}
