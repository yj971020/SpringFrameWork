package com.springbook.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Ŭ���̾�Ʈ���� �����ϴ� �����Ͱ� �ѱ��� ��� ���� ����
		request.setCharacterEncoding("UTF-8");
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//1. Ŭ���̾�Ʈ ��û  path ������ �����Ѵ�.
		String uri = request.getRequestURI();
		//  http://localhost:9900/biz/login.do
		String path = uri.substring(uri.lastIndexOf("/"));
		//  /login.do
		System.out.println(path);
		
		//2. Ŭ���̾�Ʈ ��û path�� ���� ������ �б�ó���Ѵ�.
		if(path.equals("/login.do")) {
			System.out.println("�α��� ó��");
			
			//1. ����� �Է� ���� ����(login.jsp���� ������ id, password �ޱ�)
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			//2. DB���� ó��(UserDAO�� �޼ҵ� ȣ��)
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);
			
			UserDAO userDAO = new UserDAO();
			UserVO user = userDAO.getUser(vo);
			
			//3. ȭ�� �׺���̼�(�α��� �� ȭ�� �̵� ó��)
			//�α��� ���� �� �Խ��� ��� ��ȸ ȭ������ �̵�
			if(user != null) {
				/*
					foward, include : RequestDispatcher�� �̿��Ͽ� �������� ������ ȭ���� ����
									   �� ���� ��û�� �������� ó���ǹǷ� �ӵ��� ������ URL ������� ����
									   ���� ���������� �ۼ��� �������� ������ ������
									  forward : �̵��� �������� ������� ���������� �Ѱ���
									  include : �̵��� �������� ó���� ������ �ٽ� ���� �������� ����� �Ѱ���
					redirect : �̵��� JSP���� �������� ����޽����� �����ְ� �ٽ� ������ ���û ���
					                   �ӵ��� forward, include�� ���ؼ� ������ URL�� �̵��� �������� ����
					                   ��û�� ���� ��ü�� ���� �����ؼ� �����ϱ� ������ ���� ���������� �ۼ��� ������ ������ �Ұ���
				*/
				response.sendRedirect("getBoardList.do");
			//�α��� ���� �� �ٽ� �α��� ȭ������ �̵�
			} else {
				response.sendRedirect("login.jsp");
			}
		} else if(path.equals("/logout.do")) {
			System.out.println("�α׾ƿ� ó��");
			
			//1. �������� ����� ���� ��ü�� ���� �����Ѵ�.
			HttpSession session = request.getSession();
			session.invalidate();

			//2. ���� ���� ��, �α��� ȭ������ �̵�
			response.sendRedirect("login.jsp");
		} else if(path.equals("/insertBoard.do")) {
			System.out.println("�� ��� ó��");
			
			//1. ����� �Է����� ����(insertBoard.jsp���� ���۵� ���� ����)
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			//2. DB ���� ó��(BoardDAO�� �޼ҵ� ȣ��)
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.insertBoard(vo);
			
			//3. ȭ�� �׺���̼�
			//�� ��� ó�� �� �� ��� �������� �̵�
			response.sendRedirect("getBoardList.do");
		} else if(path.equals("/updateBoard.do")) {
			System.out.println("�� ���� ó��");
			
			//1. ����� �Է����� ����(getBoard.jsp���� ���۵� ���� ����)
			String seq = request.getParameter("seq");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			//2. DB ���� ó��(BoardDAO�� �޼ҵ� ȣ��)
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			vo.setTitle(title);
			vo.setContent(content);
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.updateBoard(vo);
			
			//3. ȭ�� �׺���̼�
			//����ó�� �� �� ��� ȭ������ �̵�
			response.sendRedirect("getBoardList.do");
		} else if(path.equals("/deleteBoard.do")) {
			System.out.println("�� ���� ó��");
			
			//1.����� �Է����� ����(getBoard.jsp���� ���۵� ���� ����)
			String seq = request.getParameter("seq");

			//2. DB ���� ó��(BoardDAO�� �޼ҵ� ȣ��)
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.deleteBoard(vo);
			
			//3. ȭ�� �׺���̼�
			//�� ���� ó�� �� �� ��� ȭ������ �̵�
			response.sendRedirect("getBoardList.do");
		} else if(path.equals("/getBoard.do")) {
			System.out.println("�� �� ��ȸ ó��");
			
			//1. �� ��ȸ�� �Խñ� ��ȣ ����
			String seq = request.getParameter("seq");

			//2. DB ���� ó��(BoardDAO�� �޼ҵ� ȣ��)
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
			BoardVO board = boardDAO.getBoard(vo);
			
			//3. �˻� ����� ���ǿ� �����ϰ� ��� ȭ������ �̵��Ѵ�.
			HttpSession session = request.getSession();
			session.setAttribute("board", board);
			response.sendRedirect("getBoard.jsp");
		} else if(path.equals("/getBoardList.do")) {
			System.out.println("�� ��� �˻� ó��");
			
			//1. ����� �Է����� ����(�˻���� ���߿� ����)
			//2. DB ���� ó��(BoardDAO�� �޼ҵ� ȣ��)
			BoardVO vo = new BoardVO();
			BoardDAO boardDAO = new BoardDAO();
			List<BoardVO> boardList = boardDAO.getBoardList(vo);
			
			//3. �˻� ����� ���ǿ� �����ϰ� ��� ȭ������ �̵��Ѵ�.
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);
			response.sendRedirect("getBoardList.jsp");
		} 
	}
}
