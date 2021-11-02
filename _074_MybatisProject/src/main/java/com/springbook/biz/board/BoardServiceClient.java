package com.springbook.biz.board;

import java.util.List;

import com.springbook.biz.board.impl.BoardDAO;

public class BoardServiceClient {

	public static void main(String[] args) {
		BoardDAO boardDAO = new BoardDAO();
		
		BoardVO vo=new BoardVO();
		
		vo.setTitle("MYbatis ����");
		vo.setWriter("ȫ�浿");
		vo.setContent("Mybatis �����Դϴ�.");
		boardDAO.insertBoard(vo);
		
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList=boardDAO.getBoardList(vo);
		for(BoardVO board:boardList) {
			System.out.println("--->"+board.toString());
		}
	}

}
