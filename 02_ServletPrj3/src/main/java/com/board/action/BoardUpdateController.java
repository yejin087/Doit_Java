package com.board.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.SBoardDAO;
import com.board.model.SBoardDAOImpl;
import com.board.model.SBoardDTO;

/**
 * Servlet implementation class BoardUpdateController
 */
@WebServlet("/board/update")
public class BoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardUpdateController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 수정하기 버튼으로 넘어온 경우
		request.setCharacterEncoding("utf-8");
		int num = Integer.parseInt(request.getParameter("num"));
		SBoardDAO dao = SBoardDAOImpl.getInstance();
		SBoardDTO board = dao.findByNum(num);
		request.setAttribute("board", board);
		request.getRequestDispatcher("boardUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		int board_num = Integer.parseInt(request.getParameter("num"));
		String userid = request.getParameter("userid");
		String subject = request.getParameter("subject");
		String email = request.getParameter("email");
		String content = request.getParameter("content");

		SBoardDTO board = new SBoardDTO();
		board.setNum(board_num);
		board.setUserid(userid);
		board.setSubject(subject);
		board.setEmail(email);
		board.setContent(content);

		SBoardDAO dao = SBoardDAOImpl.getInstance();
		dao.boardUpdate(board);

		response.sendRedirect("boardlist");

	}

}
