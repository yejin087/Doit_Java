package com.file;

import java.io.IOException;

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
@WebServlet("/file/upload2.do")
public class FileController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileController2() {
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
		String encType = "utf-8"; // ���ڵ�
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);

		MultipartRequest multipart = new MultipartRequest(request, // request object
				uploadFilePath, // �������� ���� ����
				uploadFileSizeLimit, // �ִ� ���ε� ������
				encType, // ���ڵ� Ÿ��
				new DefaultFileRenamePolicy()); // ���� ���� �̸� ������ �� �� �̸� �ο�

		// ���ε� �� �����̸�
		String fileName = multipart.getFilesystemName("uploadFile");
		if (fileName == null)
			fileName = "";
		String name = multipart.getParameter("name");
		String title = multipart.getParameter("title");
		String image = fileName;

		FileDTO file = new FileDTO(name, title, image);
		FileDAO dao = FileDAO.getInstance();
		dao.fileInsert(file); // ���� db�� ����

	}

}
