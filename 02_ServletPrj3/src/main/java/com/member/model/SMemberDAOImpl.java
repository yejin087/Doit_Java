package com.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.util.DBConnection;

public class SMemberDAOImpl implements SMemberDAO {
	private static SMemberDAO instance = new SMemberDAOImpl();

	public static SMemberDAO getInstance() {

		return instance;
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

	@Override
	public void memberJoin(SMemberDTO member) {

		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into member values(?,?,?,?,?,?)";

		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getName());
			ps.setString(2, member.getUserid());
			ps.setString(3, member.getPwd());
			ps.setString(4, member.getEmail());
			ps.setString(5, member.getPhone());
			ps.setInt(6, member.getAdmin());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(null, ps, null, con);
		}

	}

	@Override
	public ArrayList<SMemberDTO> getMember() {

		String sql = "select * from member";
		ArrayList<SMemberDTO> a_mem = new ArrayList<>();

		try (Connection con = DBConnection.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);) {

			while (rs.next()) {
				SMemberDTO mem = new SMemberDTO();
				mem.setName(rs.getString("name"));
				mem.setUserid(rs.getString("userid"));
				mem.setPwd(rs.getString("pwd"));
				mem.setEmail(rs.getString("email"));
				mem.setPhone(rs.getString("phone"));
				mem.setAdmin(rs.getInt("admin"));
				a_mem.add(mem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return a_mem;
	}

	@Override
	public int memberDelete(String userid) {

		String sql = "delete from member where userid= '" + userid + "'";
		int flag = 0;
		try (Connection con = DBConnection.getConnection(); Statement st = con.createStatement();) {
			if (st.execute(sql)) {
				flag = 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public int memberUpdate(SMemberDTO member) {

		String sql = "update member set name=?, pwd=?, email=?, phone=?, admin=? where userid =?";
		int flag = 0;

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, member.getName());
			ps.setString(2, member.getPwd());
			ps.setString(3, member.getEmail());
			ps.setString(4, member.getPhone());
			ps.setInt(5, member.getAdmin());
			ps.setString(6, member.getUserid());
			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public SMemberDTO findById(String userid) {

		String sql = "select * from member where userid= '" + userid + "'";
		SMemberDTO member = new SMemberDTO();

		try (Connection con = DBConnection.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);) {
			if (rs.next()) {
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setUserid(rs.getString("userid"));
				member.setPwd(rs.getString("pwd"));
				member.setPhone(rs.getString("phone"));
				member.setAdmin(rs.getInt("admin"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return member;
	}

	@Override
	public int memberCount() {
		String sql = "select count(*) from member";
		int count = 0;

		try (Connection con = DBConnection.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);) {
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}

	@Override
	public String memberIdCheck(String userid) {

		String sql = "select * from member where userid = '" + userid + "'";
		String flag = "YES";

		try (Connection con = DBConnection.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);) {

			if (rs.next()) {
				flag = "NO";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public SMemberDTO memberLoginCheck(String userid, String pwd) {

		SMemberDTO member = new SMemberDTO();
		member.setAdmin(-1); // -1:회원아님

		String sql = "select * from member where userid ='" + userid + "'";

		try (Connection con = DBConnection.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);) {

			// 결과문이 있는 경우
			if (rs.next()) {
				if (pwd.equals(rs.getString("pwd"))) { // 비밀번호, 아이디 모두 일치
					member.setName(rs.getString("name"));
					member.setEmail(rs.getString("email"));
					member.setPhone(rs.getString("phone"));
					member.setUserid(rs.getString("userid"));
					member.setAdmin(rs.getInt("admin"));
				} else {
					member.setAdmin(2); // 아이디만 일치
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return member;
	}

}
