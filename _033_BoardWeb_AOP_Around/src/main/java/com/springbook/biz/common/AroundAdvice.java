package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {
	//ProceedingJoinPoint : 지금 실행중인 포인트컷 메소드, JoinPoint 인터페이스를 상속받아서 구현한 객체 
	//						JoinPoint를 상속 받아서 추가로 Proceed라는 메소드를 구현한 객체
	//JoinPoint의 유용한 메소드들
	/*  getSignature(): 호출된 비즈니스의 메소드의 시그니처(리턴타입 ,이름, 매개변수 ) 를 signature 객체로 담아 리턴
	 *  getTarget() ; 호출된 비즈니스 메소드를 포함하는 비즈니스 객체들을 리턴 (insertBpard 호출 시 BoardServiceImpl 객체 리턴)
	 *  getArgs() : 호출된 비즈니스 메소드의 매개변수 값들을 Object 배열로 리턴 
	 * aop:before, after-returning, after-throwing, after: JoinPoint 인터페이스 직접사용 
	 * app:around: ProceedingJoinPoint 객체를 사용해야 함 
	 * 
	 * getSignature() -> signature 객체 리턴 후 signature 객체에서 사용 가능한 메소드
	 * getName() : 호출된 포인트컷 메소드의 메소드면 String 타입으로 리턴
	 * toLongString() : 호출된 포인트컷 메소드의 리턴타입, 이름, 매개변수를 패키지경로까지 포함한 String 타입으로 리턴
	 * toShortString() : 호출된 포인터컷 메소드의 리턴타입, 이름, 매개변수를 축약해서 String 타입으로 리턴
	 * 
	 * 
	 */
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("[BEFORE]비즈니스 메소드 수행전에 처리 할 내용");
		Object returnObj=pjp.proceed();
		System.out.println("[AFTER]:비즈니스 메소드 수행 후에 처리할 내용");
		return returnObj;
	}

}
