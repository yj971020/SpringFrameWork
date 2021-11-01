package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

//SpringFramework���� �����ϴ� Controller interface�� handleRequest�޼ҵ�� ���� Ÿ�� ModelAndView
public class LoginController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�α��� ó��");
		
		//1. ����� �Է� ���� ����(login.jsp���� ������ id, password �ޱ�)
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		//2. DB���� ó��(UserDAO�� �޼ҵ� ȣ��)
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		
		//3. ȭ�� �׺���̼�(�α��� �� ȭ�� �̵� ó��)
		//DB ������ ���Ϲ��� �����Ϳ� View�� ��� ���� �� �ִ� ��ü
		ModelAndView mav = new ModelAndView();
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
			mav.setViewName("redirect:getBoardList.do");
		//�α��� ���� �� �ٽ� �α��� ȭ������ �̵�
		} else {
			mav.setViewName("redirect:login.jsp");
		}
		return mav;
	}
}
