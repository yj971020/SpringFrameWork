package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {
	//ProceedingJoinPoint : ���� �������� ����Ʈ�� �޼ҵ�, JoinPoint �������̽��� ��ӹ޾Ƽ� ������ ��ü 
	//						JoinPoint�� ��� �޾Ƽ� �߰��� Proceed��� �޼ҵ带 ������ ��ü
	//JoinPoint�� ������ �޼ҵ��
	/*  getSignature(): ȣ��� ����Ͻ��� �޼ҵ��� �ñ״�ó(����Ÿ�� ,�̸�, �Ű����� ) �� signature ��ü�� ��� ����
	 *  getTarget() ; ȣ��� ����Ͻ� �޼ҵ带 �����ϴ� ����Ͻ� ��ü���� ���� (insertBpard ȣ�� �� BoardServiceImpl ��ü ����)
	 *  getArgs() : ȣ��� ����Ͻ� �޼ҵ��� �Ű����� ������ Object �迭�� ���� 
	 * aop:before, after-returning, after-throwing, after: JoinPoint �������̽� ������� 
	 * app:around: ProceedingJoinPoint ��ü�� ����ؾ� �� 
	 * 
	 * getSignature() -> signature ��ü ���� �� signature ��ü���� ��� ������ �޼ҵ�
	 * getName() : ȣ��� ����Ʈ�� �޼ҵ��� �޼ҵ�� String Ÿ������ ����
	 * toLongString() : ȣ��� ����Ʈ�� �޼ҵ��� ����Ÿ��, �̸�, �Ű������� ��Ű����α��� ������ String Ÿ������ ����
	 * toShortString() : ȣ��� �������� �޼ҵ��� ����Ÿ��, �̸�, �Ű������� ����ؼ� String Ÿ������ ����
	 * 
	 * 
	 */
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("[BEFORE]����Ͻ� �޼ҵ� �������� ó�� �� ����");
		Object returnObj=pjp.proceed();
		System.out.println("[AFTER]:����Ͻ� �޼ҵ� ���� �Ŀ� ó���� ����");
		return returnObj;
	}

}
