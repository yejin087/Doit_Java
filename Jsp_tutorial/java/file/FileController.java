package com.file;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class FileController
 */
@WebServlet("/file/upload.do")
public class FileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileController() {
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
		String savePath = "upload"; // ������ ����� ��ġ
		int uploadFileSizeLimit = 5 * 1024 * 1024; // �ִ� ���α� ũ��
		String encType = "utf-8";
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		System.out.println("Real path in server :" + uploadFilePath);

		MultipartRequest multipart = new MultipartRequest(request, // request object
				uploadFilePath, // �������� ���� ����
				uploadFileSizeLimit, // �ִ� ���ε� ũ��
				encType, // ���ڵ� Ÿ��
				new DefaultFileRenamePolicy()); // ���� �̸� ������ �� �� �̸� �ο�

		// ���ε� �� �����̸�
		String fileName = multipart.getFilesystemName("fileUpload");
		if (fileName == null) {
			fileName = "no name";
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("writer :" + multipart.getParameter("name") + "<br>");
		out.println("title :" + multipart.getParameter("title") + "<br>");
		out.println("file name :" + fileName);
	}

}
