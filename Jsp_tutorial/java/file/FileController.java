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
		String savePath = "upload"; // 파일이 저장될 위치
		int uploadFileSizeLimit = 5 * 1024 * 1024; // 최대 업로그 크기
		String encType = "utf-8";
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		System.out.println("Real path in server :" + uploadFilePath);

		MultipartRequest multipart = new MultipartRequest(request, // request object
				uploadFilePath, // 서버상의 실제 폴더
				uploadFileSizeLimit, // 최대 업로드 크기
				encType, // 인코딩 타입
				new DefaultFileRenamePolicy()); // 동일 이름 존재할 때 새 이름 부여

		// 업로드 한 파일이름
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
