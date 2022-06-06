package com.addr.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class SAddrDAOlmpl implements SAddrDAO {

	private static SAddrDAOlmpl instance;

	public static SAddrDAOlmpl getInstance() {
		if (instance == null) {
			instance = new SAddrDAOlmpl();
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addrInsert(AddrDTO dto) {
		String sql = "insert into address values (address_seq.nextval,?,?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getAddr());
			ps.setString(3, dto.getZipcode());
			ps.setString(4, dto.getTel());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(null, ps, null, con);
		}
	}

	@Override
	public ArrayList<AddrDTO> addrList() {

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		ArrayList<AddrDTO> a_addr = new ArrayList<AddrDTO>();
		String sql = "select * from address";

		try {
			con = getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				AddrDTO dto = new AddrDTO();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				dto.setZipcode(rs.getString("zipcode"));
				dto.setTel(rs.getString("tel"));
				a_addr.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(rs, null, st, con);

		}

		return a_addr;
	}

	@Override
	public AddrDTO addrDetail(int num) {

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from address where num=" + num;
		AddrDTO dto = null;

		try {
			con = getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {
				dto = new AddrDTO();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				dto.setZipcode(rs.getString("zipcode"));
				dto.setTel(rs.getString("tel"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(rs, null, st, con);
		}

		return dto;
	}

	@Override
	public void addrUpdate(AddrDTO addr) {

		Connection con = null;
		PreparedStatement ps = null;
		String sql = "update address set name=?, zipcode=?, addr=?, tel=? where num= ?";

		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, addr.getName());
			ps.setString(2, addr.getZipcode());
			ps.setString(3, addr.getAddr());
			ps.setString(4, addr.getTel());
			ps.setInt(5, addr.getNum());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addrDelete(int num) {

		Connection con = null;
		Statement st = null;
		String sql = "delete from address where num=" + num;

		try {
			con = getConnection();
			st = con.createStatement();
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(null, null, st, con);
		}

	}

	@Override
	public ArrayList<AddrDTO> addrSearchList(String field, String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addrCount() {

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select count(*) from address";
		int count = 0;

		try {
			con = getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return count;
	}

	@Override
	public int addrSearchCount(String field, String word) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<ZipCodeDTO> addrZipRead(String dong) {

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<ZipCodeDTO> a_zip = new ArrayList<>();
		ZipCodeDTO zip = null;
		String sql = "select * from zipcode where dong like '%" + dong + "%'";
//		System.out.println(sql);
		try {
			con = getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				zip = new ZipCodeDTO();
				zip.setZipcode(rs.getString("zipcode"));
				zip.setSido(rs.getString("sido"));
				zip.setGugun(rs.getString("gugun"));
				zip.setDong(rs.getString("dong"));
				zip.setBunji(rs.getString("bunji"));
				zip.setSeq(rs.getInt("seq"));
				a_zip.add(zip);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(rs, null, st, con);
		}
		return a_zip;
	}

}
