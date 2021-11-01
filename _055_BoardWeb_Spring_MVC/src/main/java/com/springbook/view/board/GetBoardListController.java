package com.springbook.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class GetBoardListController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�� ��� �˻� ó��");
		
		//1. ����� �Է����� ����(�˻���� ���߿� ����)
		//2. DB ���� ó��(BoardDAO�� �޼ҵ� ȣ��)
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		//3. �˻� ����� ���ǿ� �����ϰ� ��� ȭ������ �̵��Ѵ�.
		ModelAndView mav = new ModelAndView();
		//ModelAndView ��ü�� ������ ���
		mav.addObject("boardList", boardList);
		//ModelAndVie ��ü�� View ���
		mav.setViewName("getBoardList");
		return mav;
	}
}
