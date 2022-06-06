package com.file;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class FileDAO {
	private static FileDAO instance;

	public static FileDAO getInstance() {
		if (instance == null) {
			instance = new FileDAO();
		}
		return instance;
	}

	// DB Driver connection using DBCP
	private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookupLink("jdbc/jsp"); // context.xml 에 등록된 Resource name
		return ds.getConnection();
	}

	public void closeConnection(ResultSet rs, PreparedStatement ps, Statement st, Connection con) {

		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 파일 추가
	public void fileInsert(FileDTO file) {
		String sql = "insert into imagetest values(?,?,?)";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, file.getName());
			ps.setString(2, file.getTitle());
			ps.setString(3, file.getImage());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 전체 보기

	public ArrayList<FileDTO> fileList() {

		String sql = "select * from imagetest";

		ArrayList<FileDTO> f_arr = new ArrayList<>();

		try (Connection con = getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);) {
			while (rs.next()) {
				String name = rs.getString("name");
				String title = rs.getString("title");
				String image = rs.getString("image");
				FileDTO file = new FileDTO(name, title, image);
				f_arr.add(file);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(f_arr.size());
		return f_arr;
	}
}
