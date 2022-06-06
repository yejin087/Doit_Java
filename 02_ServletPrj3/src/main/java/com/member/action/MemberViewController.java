package com.member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.model.SMemberDAO;
import com.member.model.SMemberDAOImpl;
import com.member.model.SMemberDTO;
import com.util.SHA256;

/**
 * Servlet implementation class MemberViewController
 */
@WebServlet("/member/update")
public class MemberViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberViewController() {
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

		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		SMemberDTO suser = (SMemberDTO) session.getAttribute("sUser");

		SMemberDAO dao = SMemberDAOImpl.getInstance();
		SMemberDTO dto = dao.findById(suser.getUserid());

		request.setAttribute("member", dto);
		request.getRequestDispatcher("memberView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		String phone = request.getParameter("phone");
		String userid = request.getParameter("userid");
		int admin = Integer.parseInt(request.getParameter("admin"));

		SMemberDTO member = new SMemberDTO();
		member.setName(name);
		member.setUserid(userid);
		member.setEmail(email);
		member.setPhone(phone);
		member.setAdmin(admin);

		// 비밀번호 암호화
		String encPwd = SHA256.getEncrypt(pwd, userid);
		member.setPwd(encPwd);

		SMemberDAO dao = SMemberDAOImpl.getInstance();
		dao.memberUpdate(member);

		response.sendRedirect("login");
	}

}
