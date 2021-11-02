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
	//Spring �����̳ʰ� �ڵ����� �޼ҵ带 ȣ�����ְ� 
	//applicationContext ���Ͽ� ��ϵ� SqlSessionFactoryBean ��ü�� ���ڷ� �޾� �޼ҵ带 ����
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
		
	}
	
	public void insertBoard(BoardVO vo) {
		System.out.println("=======> Mybatis�� insertBoard() ��� ó��");
		getSqlSession().insert("BoardDAO.insertBoard");
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("=======> Mybatis�� updateBoard() ��� ó��");
		getSqlSession().update("BoardDAO.updateBoard");
	}
	
	public void deleteBoard(BoardVO vo) {
		System.out.println("=======> Mybatis�� insertBoard() ��� ó��");
		getSqlSession().delete("BoardDAO.deleteBoard");
	}
	
	public BoardVO getBoard(BoardVO vo) {
		return (BoardVO)getSqlSession().selectOne("BoardDAO.getBoard",vo);
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> mybatis �� getBoardList ���ó��");
		return getSqlSession().selectList("BoardDAO.getBoardList",vo);
	}
	

}
