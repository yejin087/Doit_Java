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
		String savePath = "upload"; // 파일이 저장될 위치
		int uploadFileSizeLimit = 5 * 1024 * 1024; // 최대 업로그 크기
		String encType = "utf-8"; // 인코딩
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);

		MultipartRequest multipart = new MultipartRequest(request, // request object
				uploadFilePath, // 서버상의 실제 폴더
				uploadFileSizeLimit, // 최대 업로드 사이즈
				encType, // 인코딩 타입
				new DefaultFileRenamePolicy()); // 파일 동일 이름 존재할 때 새 이름 부여

		// 업로드 한 파일이름
		String fileName = multipart.getFilesystemName("uploadFile");
		if (fileName == null)
			fileName = "";
		String name = multipart.getParameter("name");
		String title = multipart.getParameter("title");
		String image = fileName;

		FileDTO file = new FileDTO(name, title, image);
		FileDAO dao = FileDAO.getInstance();
		dao.fileInsert(file); // 파일 db에 저장

	}

}
