package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

@Repository("boardDAO")
public class BoardDAOSpring {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//SQL ���� ��ɾ�
	private final String BOARD_INSERT = "INSERT INTO BOARD(SEQ, TITLE, WRITER, CONTENT) "
            + "VALUES((SELECT NVL(MAX(SEQ), 0) + 1 FROM BOARD), ?, ?, ?)";
//	private final String BOARD_INSERT = "INSERT INTO BOARD(SEQ, TITLE, WRITER, CONTENT) "
//			                          + "VALUES((SELECT NVL(MAX(SEQ), 0) + 1 FROM BOARD), ?, ?, ?)";
//	private final String BOARD_INSERT = "INSERT INTO studydb.BOARD(SEQ, TITLE, WRITER, CONTENT) "
//            + "VALUES((SELECT IFNULL(MAX(SEQ), 0) + 1 FROM BOARD A), ?, ?, ?)";
//	private final String BOARD_INSERT = "INSERT INTO studydb.BOARD(SEQ, TITLE, WRITER, CONTENT) "
//            + "VALUES((SELECT IFNULL(MAX(SEQ), 0) + 1 FROM BOARD A), vo.getTitle(), vo.getWriter(), vo.getContent())";
//	Object[] args = {vo.getTitle(), vo.getWriter(), vo.getContent()};
//	jdbcTemplate.update(BOARD_INSERT, args);
	private final String BOARD_UPDATE = "UPDATE BOARD SET TITLE = ?, CONTENT = ? WHERE SEQ = ?";
	private final String BOARD_DELETE = "DELETE FROM BOARD WHERE SEQ = ?";
	private final String BOARD_GET = "SELECT * FROM BOARD WHERE SEQ = ?";
	private final String BOARD_LIST = "SELECT * FROM BOARD ORDER BY SEQ DESC";
	private final String BOARD_LIST_T = "SELECT * FROM BOARD WHERE TITLE LIKE '%' || ? || '%' ORDER BY SEQ DESC";
	private final String BOARD_LIST_C = "SELECT * FROM BOARD WHERE CONTENT LIKE '%' || ? || '%' ORDER BY SEQ DESC";
	//MySql
	//private final String BOARD_LIST_T = "SELECT * FROM BOARD WHERE TITLE LIKE CONCAT_WS('%', ?, '%') ORDER BY SEQ DESC";
	//private final String BOARD_LIST_C = "SELECT * FROM BOARD WHERE CONTENT LIKE CONCAT_WS('%', ?, '%') ORDER BY SEQ DESC";
	
	//CRUD ����� �޼ҵ� ����
	//�� ���
	//getJdbcTemplate() : JdbcTemplate��ü�� ����. JdbcDaoSupport Ŭ�������� ��ӹ޾� ����ϴ� �޼ҵ�
	public void insertBoard(BoardVO vo) {
		System.out.println("====> JDBC�� insertBoard() ��� ó��");
		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}
	
	//�� ����
	public void updateBoard(BoardVO vo) {
		System.out.println("====> JDBC�� upadateBoard() ��� ó��");
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}
	
	//�� ����
	public void deleteBoard(BoardVO vo) {
		System.out.println("====> JDBC�� deleteBoard() ��� ó��");
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	}
	
	//�� �� ��ȸ
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("====> JDBC�� getBoard() ��� ó��");
		Object[] args = {vo.getSeq()};
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
	}
	
	//�� ��� ��ȸ
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("====> JDBC�� getBoard() ��� ó��");
		Object[] args = {vo.getSearchKeyword()};
		
		System.out.println("con===============" + vo.getSearchCondition());
		System.out.println("key===============" + vo.getSearchKeyword());
		
		if(vo.getSearchCondition().equals("TITLE")) {
			return jdbcTemplate.query(BOARD_LIST_T, args, new BoardRowMapper());
		} else if(vo.getSearchCondition().equals("CONTENT")) {
			return jdbcTemplate.query(BOARD_LIST_C, args, new BoardRowMapper());
		}
		
		return null;
	}
}
