package com.springbook.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {
	@RequestMapping(value="/logout.do")
	//Command ��ü�� HttpSession�� �����ϰ� �Ǹ� �����������̳ʰ� �������� ���ε� ���ǰ�ü�� ��Ƽ� �Ѱ���
	public String logout(HttpSession session) {
		System.out.println("�α׾ƿ� ó��");
		
		session.invalidate();
		return "login.jsp";
	}
}
