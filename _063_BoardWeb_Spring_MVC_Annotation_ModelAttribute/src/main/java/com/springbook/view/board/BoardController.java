package com.springbook.view.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class BoardController {
	//@ModelAttribute : 1. Command ��ü �̸� ����
	//					2. View(JSP)���� ����� ������ ����
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("����", "TITLE");
		conditionMap.put("����", "CONTENT");
		//���� ���� ReqeustServlet ������ �����ҿ� ����
		//conditionMap�̶�� Ű ������ �����Ͱ� ����
		return conditionMap;
	}
	
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
	
	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("�� ���� ó��");
		 System.out.println("�ۼ��� �̸� : " + vo.getWriter());
		boardDAO.updateBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("�� ���� ó��");
		
		boardDAO.deleteBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping(value="/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("�� �� ��ȸ ó��");
		
		//Model ��ü�� RequestServlet ������ �����ҿ� ����
		//RequestServlet ������ �����ҿ� �����ϴ� �Ͱ� �����ϰ� ����
		//request.setAttribute("board", boardDAO.getBoard(vo)) == model.addAttribute("board", boardDAO.getBoard(vo))
		model.addAttribute("board", boardDAO.getBoard(vo));
		return "getBoard.jsp";
	}
	
	@RequestMapping(value="/getBoardList.do")
	//@RequestParam : Command ��ü�� VO�� ���ΰ��� ���� ����� �Է������� ���� �޾Ƽ� ó��
	//				  value = ȭ�����κ��� ���޵� �Ķ���� �̸�(jsp�� input�� name�Ӽ� ��)
	//				  required = ���� ���� ����
	public String getBoardList( /*
								 * @RequestParam(value="searchCondition", defaultValue="TITLE", required=false)
								 * String condition,
								 * 
								 * @RequestParam(value="searchKeyword", defaultValue="", required=false) String
								 * keyword,
								 */
								BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("�� ��� �˻� ó��");
		
		model.addAttribute("boardList", boardDAO.getBoardList(vo));
		return "getBoardList.jsp";
	}
}
