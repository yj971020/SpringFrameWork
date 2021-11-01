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
		System.out.println("글 목록 검색 처리");
		
	//ModelAndview 객체에 데이터 담기
		ModelAndView mav = new ModelAndView();
		//ModelAndView 객체에 데이터 담기
		mav.addObject("boardList", boardList);
		//ModelAndVie 객체에 View 담기
		mav.setViewName("getBoardList");
		return mav;
	}
}
