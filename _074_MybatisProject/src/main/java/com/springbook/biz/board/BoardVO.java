package com.springbook.biz.board;
//sql->util 로 변경 : xml 로 변환하려면 기본 생성자가 필요한데 java.sql.Date 는 기본생성자가 없다.
import java.util.Date;


public class BoardVO {

	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;

	private String SearchCondition;

	private String SearchKeyword;

	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getSearchCondition() {
		return SearchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		SearchCondition = searchCondition;
	}
	public String getSearchKeyword() {
		return SearchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		SearchKeyword = searchKeyword;
	}

	
	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regDate="
				+ regDate + ", cnt=" + cnt + "]";
	}	
}
