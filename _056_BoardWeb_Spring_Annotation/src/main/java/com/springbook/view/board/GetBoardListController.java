package com.springbook.view.board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class GetBoardListController {
	@RequestMapping(value="/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo,BoardDAO boardDAO,ModelAndview modelandview) {
		System.out.println("�� ��� �˻� ó��");
		
	//ModelAndview ��ü�� ������ ���
		ModelAndView mav = new ModelAndView();
		//ModelAndView ��ü�� ������ ���
		mav.addObject("boardList", boardList);
		//ModelAndVie ��ü�� View ���
		mav.setViewName("getBoardList");
		return mav;
	}
}
