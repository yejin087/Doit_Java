package com.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.board.dto.BoardDTO;
import com.board.dto.CommentDTO;
import com.util.DBConnection;

public class BoardDAO {

	private static BoardDAO instance = new BoardDAO();

	public static BoardDAO getInstance() {
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

	// �߰�
	public void boardInsert(BoardDTO board) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		int number = 0;

		// ����� ��� �ʿ��� ��
		int num = board.getNum();
		int ref = board.getRef();
		int re_step = board.getRe_step();
		int re_level = board.getRe_level();

		try {
			con = DBConnection.getConnection();

			// ref �� ����
			ps = con.prepareStatement("select max(num) from board");
			rs = ps.executeQuery();
			if (rs.next()) { // ���� ���� �� ���� num ���� ���� ū ���� ref�� ����
				number = rs.getInt(1) + 1;
			} else { // ���� �������� ���� ��� ref�� 1�� ����
				number = 1;
			}
			if (num != 0) {
				// ���� re_step ����
				// ref�� ���� , re_step�� ū�͸� update
				sql = "update board set re_step = re_step+1 where ref =? and re_step > ?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, ref);
				ps.setInt(2, re_step);
				ps.executeUpdate();

				// ���� �� ������
				re_step = re_step + 1; // �θ� re_step���� +!
				re_level = re_level + 1; // �θ� re_level���� +1
			} else { // �� ���ϰ��
				ref = number;
				re_step = 0;
				re_level = 0;
			}

			sql = "insert into board (num,writer,subject,email,content,ip,ref,re_step,re_level,passwd) values (board_seq.nextval,?,?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getWriter());
			ps.setString(2, board.getSubject());
			ps.setString(3, board.getEmail());
			ps.setString(4, board.getContent());
			ps.setString(5, board.getIp());
			ps.setInt(6, ref);
			ps.setInt(7, re_step);
			ps.setInt(8, re_level);
			ps.setString(9, board.getPasswd());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(null, null, ps, con);
		}
	}

	// ��ü ����
	// �˻� ��ü ����, �⺻ ��ü ���� �ΰ��� ���� ������ ����������.
	public ArrayList<BoardDTO> boardList(String field, String word, int StartRow, int endRow) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<BoardDTO> a_board = new ArrayList<BoardDTO>();
		String sql = "";

		try {
			con = DBConnection.getConnection();

//			if (word.equals("")) { // �˻� �ƴ�
//				sql = "select * from board order by ref desc, re_step asc";
//			} else {
//				sql = "select * from board where " + field + " like '%" + word + "%' order by ref desc, re_step asc";
//			}

			StringBuilder sb = new StringBuilder();
			if (word.equals("")) { // �˻� �ƴ�
				sb.append("select * from (");
				sb.append("select rownum rn, aa.* from (");
				sb.append("select * from board order by ref desc, re_step asc) aa");
				sb.append(" where rownum <= ?");
				sb.append(") where rn>=?");
			} else { // �˻�
				sb.append("select * from (");
				sb.append("select rownum rn, aa.* from (");
				sb.append("select * from board where " + field + " like '%" + word + "%'");
				sb.append(" order by ref desc, re_step asc) aa");
				sb.append(" where rownum <= ?");
				sb.append(") where rn>=?");
			}
			ps = con.prepareStatement(sb.toString());
			ps.setInt(1, endRow);
			ps.setInt(2, StartRow);
			rs = ps.executeQuery();

			while (rs.next()) {
				BoardDTO board = new BoardDTO();
				board.setNum(rs.getInt("num"));
				board.setSubject(rs.getString("subject"));
				board.setWriter(rs.getString("writer"));
				board.setReg_date(rs.getString("reg_date"));
				board.setReadcount(rs.getInt("readcount"));
				a_board.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(rs, null, ps, con);
		}

		return a_board;
	}

	// �� ����
	public BoardDTO findByNum(int num) {

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		BoardDTO board = null;
		String sql = "";

		try {
			con = DBConnection.getConnection();
			st = con.createStatement();

			// ��ȸ�� ����
			sql = "update board set readcount=readcount+1 where num=" + num;
			st.executeUpdate(sql);

			// ���ڷ� �� ã��
			sql = "select * from board where num=" + num;
			rs = st.executeQuery(sql);

			if (rs.next()) {
				board = new BoardDTO();
				board.setNum(rs.getInt("num"));
				board.setReadcount(rs.getInt("readcount"));
				board.setWriter(rs.getString("writer"));
				board.setReg_date(rs.getString("reg_date"));
				board.setSubject(rs.getString("subject"));
				board.setContent(rs.getString("content"));
				board.setEmail(rs.getString("email"));
				board.setRef(rs.getInt("ref"));
				board.setRe_step(rs.getInt("re_step"));
				board.setRe_level(rs.getInt("re_level"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(rs, st, null, con);
		}

		return board;
	}

	// ����
	public int boardUpdate(BoardDTO board) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		int flag = 0;

		try {
			con = DBConnection.getConnection();
			sql = "select passwd from board where num=" + board.getNum();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(); // ��� ���ؿ´�

			if (rs.next()) {
				// ��� ��ȣ�� ���ٸ� Update ����
				if (rs.getString("passwd").equals(board.getPasswd())) {
					sql = "update board set  subject=?, email=?, content=?, ip=?, reg_date=sysdate where num=?";
					ps = con.prepareStatement(sql);
					ps.setString(1, board.getSubject());
					ps.setString(2, board.getEmail());
					ps.setString(3, board.getContent());
					ps.setString(4, board.getIp());
					ps.setInt(5, board.getNum());
					flag = ps.executeUpdate(); // Update�� ���� ���� ��ȯ ���������� Update �Ǿ��ٸ� 1�� ��ȯ�ȴ�.
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(null, null, ps, con);
		}
		return flag;
	}

	// ����
	public int boardDelete(int num) {

		String sql = "delete from board where num =" + num;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
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
		} finally {
			closeConnection(rs, st, null, con);
		}

		return flag;
	}

	// ����
	public int getCount(String field, String word) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "";
		int count = 0;

		try {
			con = DBConnection.getConnection();
			st = con.createStatement();

			if (word.equals("")) {
				sql = "select count(*) from board";
			} else {
				sql = "select count(*) from board where " + field + " like '%" + word + "%'";
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

	// comment Insert
	public void commentInsert(CommentDTO comment) {
		String sql = "insert into commentboard values(commentboard_seq.nextval,?,?,sysdate,?)";
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, comment.getMsg());
			ps.setString(2, comment.getUserid());
			ps.setInt(3, comment.getBnum());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(null, null, ps, con);
		}

	}

	// comment list
	public ArrayList<CommentDTO> commentList(int bnum) {

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "";
		ArrayList<CommentDTO> a_comm = new ArrayList<CommentDTO>();
		CommentDTO comment = null;
		sql = "select * from commentboard where bnum =" + bnum + " order by cnum desc";

		try {
			con = DBConnection.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				comment = new CommentDTO();
				comment.setBnum(bnum);
				comment.setCnum(rs.getInt("cnum"));
				comment.setUserid(rs.getString("userid"));
				comment.setMsg(rs.getString("msg"));
				comment.setRegdate(rs.getString("regdate"));
				a_comm.add(comment);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(rs, st, null, con);
		}

		return a_comm;
	}

	// comment count
	public int getcommCount(int bnum) {

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int count = 0;
		String sql = "";
		sql = "select count(*) from commentboard where bnum=" + bnum;

		try {
			con = DBConnection.getConnection();
			st = con.createStatement();
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
}
