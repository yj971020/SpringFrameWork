package com.springbook.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

//SpringFramework���� �����ϴ� Controller interface�� handleRequest�޼ҵ�� ���� Ÿ�� ModelAndView
@Controller
public class LoginController {
	//GET������� ��û�� ���� �α���ȭ������ Post������� ��û�� ���� �α��� ó��
	//@RequestMapping(value="/login.do", method=RequestMethod.GET)
	@GetMapping(value="/login.do")
	//userVO�� �̸����� Command��ü ����
	//�̸��� ���� ���� �ÿ� �ڵ����� ù���ڰ� �ҹ��ڷ� ����� �̸����� ������
	//Command ��ü�� �̸� ���� : @ModelAttribute("user") -> user�� �̸��� Command ��ü ����
	public String loginView(@ModelAttribute("user")UserVO vo) {
		System.out.println("�α��� ȭ������ �̵�");
		//�α���ȭ������ �̵��� ó�� �Է°� ����
		vo.setId("test");
		vo.setPassword("test123");
		return "login.jsp";
	}
	
	//@RequestMapping(value="/login.do", method=RequestMethod.POST)
	@PostMapping(value="/login.do")
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
		System.out.println("�α��� ó��");
		UserVO user = userDAO.getUser(vo);
		
		if(vo.getId() == null || vo.getId().equals("")) {
			throw new IllegalArgumentException("���̵�� �ݵ�� �Է��ؾ� �˴ϴ�.");
		}
		
		//�α��� ���� �� �Խ��� ��� ��ȸ ȭ������ �̵�
		if(user != null) {
			/*
				foward, include : RequestDispatcher�� �̿��Ͽ� �������� ������ ȭ���� ����
								   �� ���� ��û�� �������� ó���ǹǷ� �ӵ��� ������ URL ������� ����
								   ���� ���������� �ۼ��� �������� ������ ������
								  forward : �̵��� �������� ������� ���������� �Ѱ���
								  include : �̵��� �������� ó���� ������ �ٽ� ���� �������� ����� �Ѱ���
				redirect : �̵��� JSP���� �������� ����޽����� �����ְ� �ٽ� ������ ���û ���
				                   �ӵ��� forward, include�� ���ؼ� ������ URL�� �̵��� �������� ����
				                   ��û�� ���� ��ü�� ���� �����ؼ� �����ϱ� ������ ���� ���������� �ۼ��� ������ ������ �Ұ���
			*/
			//redirect : viewResolver�� �����ϰ� �ٷ� �����̷�Ʈ
			//UserVO�� name ������ session ������ �����ҿ� userName�̶�� Ű ������ ����
			session.setAttribute("userName", user.getName());
			//UserVO ��ü�� session ������ �����ҿ� user��� Ű ������ ����
//			session.setAttribute("user", user);
			return "redirect:getBoardList.do";
		//�α��� ���� �� �ٽ� �α��� ȭ������ �̵�
		} else {
			return "login.jsp";
		}
	}
}
