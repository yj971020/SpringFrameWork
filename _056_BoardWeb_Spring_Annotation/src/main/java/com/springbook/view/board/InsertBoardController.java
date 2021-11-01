package com.springbook.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class InsertBoardController {
	//@RequestMapping : HandlerMapping ���, �޼ҵ� Ÿ�Կ� ������� ȣ�� �� ������ ����
	//�޼ҵ� Ÿ�Կ� ���� @GetMapping, @PostMapping
	@RequestMapping(value="/insertBoard.do")
	//Command ��ü : ����ڰ� ������ �����͸� ������ VO�� �ٷ� ����
	//				����� �Է� ���� �������� �ڵ尡 ������� ������ ����ȭ ����
	//              ����� �Է� input�� name �Ӽ��� VO ��������� �̸��� �������ִ� ���� �߿�
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("�� ��� ó��");
		
		/*
		 * //1. ����� �Է����� ����(insertBoard.jsp���� ���۵� ���� ����) String title =
		 * request.getParameter("title"); String writer =
		 * request.getParameter("writer"); String content =
		 * request.getParameter("content");
		 * 
		 * //2. DB ���� ó��(BoardDAO�� �޼ҵ� ȣ��) BoardVO vo = new BoardVO();
		 * vo.setTitle(title); vo.setWriter(writer); vo.setContent(content);
		 */
		boardDAO.insertBoard(vo);
		
		//ȭ�� �׺���̼�(�Խñ� ��� �Ϸ� �� �Խñ� ������� �̵�)
		return "redirect:getBoardList.do";
	}
}
