package com.springbook.biz.board.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

@Repository
public class BoardDAOMybatis extends SqlSessionDaoSupport {
	@Autowired
	//Spring 컨테이너가 자동으로 메소드를 호출해주고 
	//applicationContext 파일에 등록된 SqlSessionFactoryBean 객체를 인자로 받아 메소드를 실행
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
		
	}
	
	public void insertBoard(BoardVO vo) {
		System.out.println("=======> Mybatis로 insertBoard() 기능 처리");
		getSqlSession().insert("BoardDAO.insertBoard");
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("=======> Mybatis로 updateBoard() 기능 처리");
		getSqlSession().update("BoardDAO.updateBoard");
	}
	
	public void deleteBoard(BoardVO vo) {
		System.out.println("=======> Mybatis로 insertBoard() 기능 처리");
		getSqlSession().delete("BoardDAO.deleteBoard");
	}
	
	public BoardVO getBoard(BoardVO vo) {
		return (BoardVO)getSqlSession().selectOne("BoardDAO.getBoard",vo);
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> mybatis 로 getBoardList 기능처리");
		return getSqlSession().selectList("BoardDAO.getBoardList",vo);
	}
	

}
