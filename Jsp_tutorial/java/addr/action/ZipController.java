package com.addr.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.addr.model.SAddrDAO;
import com.addr.model.SAddrDAOlmpl;
import com.addr.model.ZipCodeDTO;

/**
 * Servlet implementation class ZipController
 */
@WebServlet("/Addr/zipcheck.addr")
public class ZipController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ZipController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("addr_zip.jsp");
		rd.forward(request, response);
		// doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String dong = request.getParameter("dong");
//		String dong = "ºÎÀüµ¿";

		SAddrDAO saddr = SAddrDAOlmpl.getInstance();
		ArrayList<ZipCodeDTO> z_arr = saddr.addrZipRead(dong);

		JSONArray z_jarr = new JSONArray();
		for (ZipCodeDTO zdto : z_arr) {
			JSONObject obj = new JSONObject();
			obj.put("zipcode", zdto.getZipcode());
			obj.put("sido", zdto.getSido());
			obj.put("gugun", zdto.getGugun());
			obj.put("dong", zdto.getDong());
			obj.put("bunji", zdto.getBunji());
			z_jarr.add(obj);
		}

		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(z_jarr.toString());
//		request.setAttribute("a_zipcodDTO", z_arr);
//
//		request.getRequestDispatcher("addr_zip.jsp").forward(request, response);

	}
}
