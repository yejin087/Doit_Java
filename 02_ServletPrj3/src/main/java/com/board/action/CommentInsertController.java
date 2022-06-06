package com.board.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.model.SBoardDAO;
import com.board.model.SBoardDAOImpl;
import com.board.model.SCommentDTO;
import com.member.model.SMemberDTO;

/**
 * Servlet implementation class CommentInsertController
 */
@WebServlet("/board/commentInsert")
public class CommentInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommentInsertController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		int bnum = Integer.parseInt(request.getParameter("bnum"));
		String msg = request.getParameter("msg");

		HttpSession session = request.getSession();
		SMemberDTO suser = (SMemberDTO) session.getAttribute("sUser");

		if (suser == null) {
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.println(1);
			return;
		}

		SBoardDAO dao = SBoardDAOImpl.getInstance();
		SCommentDTO comment = new SCommentDTO();
		comment.setBnum(bnum);
		comment.setMsg(msg);
		comment.setUserid(suser.getUserid());
		dao.commentInsert(comment);

	}

}
