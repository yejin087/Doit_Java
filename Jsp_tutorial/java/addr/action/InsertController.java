package com.addr.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.addr.model.AddrDTO;
import com.addr.model.SAddrDAO;
import com.addr.model.SAddrDAOlmpl;

/**
 * Servlet implementation class InsertController
 */
@WebServlet("/Addr/insert.addr")
public class InsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("addr_insert.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String zipcode = request.getParameter("zipcode");
		String tel = request.getParameter("tel");

		AddrDTO address = new AddrDTO();
		address.setName(name);
		address.setAddr(addr);
		address.setZipcode(zipcode);
		address.setTel(tel);

		SAddrDAO saddr = SAddrDAOlmpl.getInstance();
		saddr.addrInsert(address);

		response.sendRedirect("list.addr");

	}

}
