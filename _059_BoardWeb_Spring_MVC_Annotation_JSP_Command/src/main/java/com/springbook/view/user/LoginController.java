package com.springbook.view.user;

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
	public String login(UserVO vo, UserDAO userDAO) {
		System.out.println("�α��� ó��");
		
		//�α��� ���� �� �Խ��� ��� ��ȸ ȭ������ �̵�
		if(userDAO.getUser(vo) != null) {
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
			return "redirect:getBoardList.do";
		//�α��� ���� �� �ٽ� �α��� ȭ������ �̵�
		} else {
			return "login.jsp";
		}
	}
}
