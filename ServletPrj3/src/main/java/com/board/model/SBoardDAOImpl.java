package com.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.util.DBConnection;

public class SBoardDAOImpl implements SBoardDAO {
	private static SBoardDAO instance = new SBoardDAOImpl();

	public static SBoardDAO getInstance() {

		return instance;
	}

	public void closeConnection(ResultSet rs, Statement st, PreparedStatement ps, Connection con) {

		try {
			if (rs != null)
				rs.close();

			if (st != null)
				st.close();
			if (ps != null)
				ps.close();

			if (con != null)
				con.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	public void boardInsert(SBoardDTO board) {

		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into simpleboard (num,userid,subject,email,content) values (simpleboard_seq.nextval,?,?,?,?)";

		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getUserid());
			ps.setString(2, board.getSubject());
			ps.setString(3, board.getEmail());
			ps.setString(4, board.getContent());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(null, null, ps, con);
		}
	}

	@Override
	public void boardUpdate(SBoardDTO board) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "update simpleboard set subject=?, email=?, content=?, regdate=sysdate where num=?";

		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getSubject());
			ps.setString(2, board.getEmail());
			ps.setString(3, board.getContent());
			ps.setInt(4, board.getNum());
			ps.executeUpdate(); // Update된 행의 수를 반환 정상적으로 Update 되었다면 1이 반환된다.

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(null, null, ps, con);
		}

	}

	@Override
	public ArrayList<SBoardDTO> boardList(int startRow, int endRow, String field, String word) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<SBoardDTO> board_arr = new ArrayList<>();
		String sql = "select * from (select rownum rn, aa.* from(select * from simpleboard where " + field + " like '%"
				+ word + "%' order by num desc) aa where rownum <= ?) where rn>=?";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, endRow);
			ps.setInt(2, startRow);
			rs = ps.executeQuery();
			while (rs.next()) {
				SBoardDTO board = new SBoardDTO();
				board.setNum(rs.getInt("num"));
				board.setUserid(rs.getString("userid"));
				board.setSubject(rs.getString("subject"));
				board.setEmail(rs.getString("email"));
				board.setReadcount(rs.getInt("readcount"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getString("regdate"));
				board_arr.add(board);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(rs, null, ps, con);
		}
		return board_arr;
	}

	@Override
	public ArrayList<SBoardDTO> boardList() {

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<SBoardDTO> a_board = new ArrayList<SBoardDTO>();
		String sql = "";

		try {
			sql = "select * from simpleboard";
			con = DBConnection.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				SBoardDTO board = new SBoardDTO();
				board.setNum(rs.getInt("num"));
				board.setUserid(rs.getString("userid"));
				board.setSubject(rs.getString("subject"));
				board.setEmail(rs.getString("email"));
				board.setReadcount(rs.getInt("readcount"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getString("regdate"));
				a_board.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(rs, st, null, con);
		}

		return a_board;
	}

	@Override
	public int boardDelete(int num) {

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "delete from simpleboard where num=" + num;
		int flag = 0;

		try {
			con = DBConnection.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {
				flag = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public int boardCount(String field, String word) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "";
		int count = 0;

		try {
			con = DBConnection.getConnection();
			st = con.createStatement();

			if (word.equals("")) {
				sql = "select count(*) from simpleboard";
			} else {
				sql = "select count(*) from simpleboard where " + field + " like '%" + word + "%'";
			}

			rs = st.executeQuery(sql);

			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(rs, st, null, con);
		}
		return count;
	}

	@Override
	public SBoardDTO findByNum(int num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		SBoardDTO board = null;
		String sql = "";

		try {
			con = DBConnection.getConnection();
			st = con.createStatement();

			// 숫자로 글 찾기
			sql = "select * from simpleboard where num=" + num;
			rs = st.executeQuery(sql);

			if (rs.next()) {
				board = new SBoardDTO();
				board.setNum(rs.getInt("num"));
				board.setReadcount(rs.getInt("readcount"));
				board.setUserid(rs.getString("userid"));
				board.setRegdate(rs.getString("regdate"));
				board.setSubject(rs.getString("subject"));
				board.setContent(rs.getString("content"));
				board.setEmail(rs.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(rs, st, null, con);
		}

		return board;
	}

	@Override
	public void commentInsert(SCommentDTO comment) {

		String sql = "insert into comboard values(commentboard_seq.nextval,?,?,sysdate,?)";
		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, comment.getUserid());
			ps.setString(2, comment.getMsg());
			ps.setInt(3, comment.getBnum());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<SCommentDTO> findAllComment(int bnum) {

		ArrayList<SCommentDTO> comm_arr = new ArrayList<>();
		SCommentDTO comment = null;
		String sql = "select * from comboard where bnum =" + bnum;

		try (Connection con = DBConnection.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);) {
			while (rs.next()) {
				comment = new SCommentDTO();
				comment.setCnum(rs.getInt("cnum"));
				comment.setUserid(rs.getString("userid"));
				comment.setMsg(rs.getString("msg"));
				comment.setRegdate(rs.getString("regdate"));
				comment.setBnum(rs.getInt("bnum"));
				comm_arr.add(comment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return comm_arr;
	}

	@Override
	public int commentCount(int bnum) {

		String sql = "select count(*) from comboard where bnum =" + bnum;
		int count = 0;
		try (Connection con = DBConnection.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);) {
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

}
