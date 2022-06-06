package com.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.member.dto.MemberDTO;
import com.util.DBConnection;

public class MemberDAOImpl implements MemberDAO {

	private static MemberDAOImpl instance = new MemberDAOImpl();

	public static MemberDAOImpl getInstance() {
		return instance;
	}

	@Override
	public void memberInsert(MemberDTO dto) {
//		System.out.println("pwd : " + dto.getPwd());

		String sql = "insert into member values(?,?,?,?,?,?)";
		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getUserid());
			ps.setString(3, dto.getPwd());
			ps.setString(4, dto.getEmail());
			ps.setString(5, dto.getPhone());
			ps.setInt(6, dto.getAdmin());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<MemberDTO> memberList() {

		String sql = "select * from member";
		ArrayList<MemberDTO> a_mem = new ArrayList<>();

		try (Connection con = DBConnection.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);) {

			while (rs.next()) {
				MemberDTO mem = new MemberDTO();
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
	public void memeberUpdate(MemberDTO dto) {
		String sql = "update member set name=?, pwd=?, email=?, phone=?, admin=? where userid =?";
		System.out.println(dto.toString());
		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getPwd());
			ps.setString(3, dto.getEmail());
			ps.setString(4, dto.getPhone());
			ps.setInt(5, dto.getAdmin());
			ps.setString(6, dto.getUserid());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void memeberDelete(String userid) {
		String sql = "delete from member where userid= '" + userid + "'";
		try (Connection con = DBConnection.getConnection(); Statement st = con.createStatement();) {
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public MemberDTO findById(String userid) {
		String sql = "select * from member where userid= '" + userid + "'";
		MemberDTO member = new MemberDTO();

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

	// 아이디가 DB에 존재 하는지 확인
	@Override
	public String idCheck(String userid) {
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
	public int loginCheck(String userid, String pwd) {
		String sql = "select pwd, admin from member where userid ='" + userid + "'";
		int flag = -1; // -1:회원아님, 0:회원, 2:비번 오류
		try (Connection con = DBConnection.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);) {

			// 결과문이 있는 경우
			if (rs.next()) {
				if (pwd.equals(rs.getString("pwd"))) { // 비밀번호, 아이디 모두 일치
					flag = rs.getInt("admin");
				} else {
					flag = 2; // 아이디만 일치
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	// 회원 수
	@Override
	public int getcount() {
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

}
