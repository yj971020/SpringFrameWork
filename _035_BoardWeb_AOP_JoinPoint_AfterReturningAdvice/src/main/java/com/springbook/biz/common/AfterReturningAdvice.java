package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;

import com.springbook.biz.user.UserVO;

public class AfterReturningAdvice {
	public void afterReturningAdvice(JoinPoint jp,Object returnObj) {
		String method=jp.getSignature().getName();
		if(returnObj instanceof UserVO) {
			UserVO user=(UserVO)returnObj;
			if(user.getRole().equals("Admin")) {
				System.out.println(user.getName()+"로그인(Admin)");
			}
		}
		System.out.println("[사후 처리] 비즈니르 로직 수행 후 동작"+method+"()메소드 리턴 값"+returnObj.toString());
	}
}
