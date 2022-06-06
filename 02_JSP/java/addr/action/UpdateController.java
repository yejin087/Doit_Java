package com.addr.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.addr.model.AddrDTO;
import com.addr.model.SAddrDAO;
import com.addr.model.SAddrDAOlmpl;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/Addr/update.addr")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int num = Integer.parseInt(request.getParameter("num"));
		String name = request.getParameter("name");
		String zipcode = request.getParameter("zipcode");
		String addr = request.getParameter("addr");
		String tel = request.getParameter("tel");

		AddrDTO dto = new AddrDTO();
		dto.setNum(num);
		dto.setName(name);
		dto.setAddr(addr);
		dto.setZipcode(zipcode);
		dto.setTel(tel);

		SAddrDAO saddr = SAddrDAOlmpl.getInstance();
		saddr.addrUpdate(dto);

		response.sendRedirect("list.addr");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
