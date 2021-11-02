package com.springbook.biz.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

@Repository
public class BoardDAOMybatis{
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertBoard(BoardVO vo) {
		System.out.println("=======> Mybatis�� insertBoard() ��� ó��");
		mybatis.insert("BoardDAO.insertBoard",vo);
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("=======> Mybatis�� updateBoard() ��� ó��");
		mybatis.update("BoardDAO.updateBoard",vo);
	}
	
	public void deleteBoard(BoardVO vo) {
		System.out.println("=======> Mybatis�� insertBoard() ��� ó��");
		mybatis.delete("BoardDAO.deleteBoard",vo);
	}	
	public BoardVO getBoard(BoardVO vo) {
		return (BoardVO)mybatis.selectOne("BoardDAO.getBoard",vo);
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> mybatis �� getBoardList ���ó��");
		return mybatis.selectList("BoardDAO.getBoardList",vo);
	}
	

}
