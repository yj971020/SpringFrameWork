package com.springbook.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LogoutController {
	@RequestMapping(value="/updateBoard.do")
	//Command 객체로 HttpSession 을 선언하게 되면 스프링 컨테이너가 브라우저 매핑된 세션객체를 담아서 넘겨중
	public String logout(HttpSession session) {
		System.out.println("로그아웃 처리");
		
		session.invalidate();
		return "login.jsp";
		
	}
}
