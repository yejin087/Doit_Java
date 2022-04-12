package com.jqueryAddress;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JAddressDAOImpl implements JAddressDAO {
	private static JAddressDAO instance;

	// singleton은 static으로 ~
	public static JAddressDAO getInstance() {

		if (instance == null)

		{
			instance = new JAddressDAOImpl();
		}
		return instance;
	}

	private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookupLink("jdbc/jsp");
		return ds.getConnection();
	}

	private void closeConnection(ResultSet rs, PreparedStatement ps, Statement st, Connection con) {

		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(AddressVO avo) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into address values(address_seq.nextval,?,?,?,?)";
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, avo.getName());
			ps.setString(2, avo.getAddr());
			ps.setString(3, avo.getZipcode());
			ps.setString(4, avo.getTel());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(null, ps, null, con);
		}
	}

	@Override
	public ArrayList<AddressVO> list() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from address";

		ArrayList<AddressVO> a_avo = new ArrayList<AddressVO>();
		try {

			con = getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				AddressVO avo = new AddressVO();
				avo.setNum(rs.getInt("num"));
				avo.setName(rs.getString("name"));
				avo.setAddr(rs.getString("addr"));
				avo.setZipcode(rs.getString("zipcode"));
				avo.setTel(rs.getString("tel"));
				a_avo.add(avo);
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			closeConnection(rs, null, st, con);
		}

		return a_avo;
	}

	@Override
	public AddressVO findByNum(int num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from address where num=" + num;
		AddressVO avo = new AddressVO();
		try {
			con = getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {
				avo.setNum(rs.getInt("num"));
				avo.setName(rs.getString("name"));
				avo.setAddr(rs.getString("addr"));
				avo.setZipcode(rs.getString("zipcode"));
				avo.setTel(rs.getString("tel"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(rs, null, st, con);
		}

		return avo;
	}

	@Override
	public void update(AddressVO avo) {

		Connection con = null;
		PreparedStatement ps = null;
		String sql = "update address set name=?, zipcode=?, addr=?, tel=? where num =" + avo.getNum();

		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, avo.getName());
			ps.setString(2, avo.getZipcode());
			ps.setString(3, avo.getAddr());
			ps.setString(4, avo.getTel());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int num) {

		Connection con = null;
		Statement st = null;
		String sql = "delete from address where num =" + num;

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
	public ArrayList<AddressVO> searchList(String field, String word) {

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from address where " + field + " like '%" + word + "%'";
		ArrayList<AddressVO> a_avo = new ArrayList<AddressVO>();

		try {
			con = getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				AddressVO avo = new AddressVO();
				avo.setNum(rs.getInt("num"));
				avo.setName(rs.getString("name"));
				avo.setAddr(rs.getString("addr"));
				avo.setZipcode(rs.getString("zipcode"));
				avo.setTel(rs.getString("tel"));
				a_avo.add(avo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(rs, null, st, con);
		}

		return a_avo;
	}

	@Override
	public ArrayList<ZipCodeVO> getZipcode(String dong) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<ZipCodeVO> z_arr = new ArrayList<ZipCodeVO>();

		try {
			con = getConnection();
			String sql = "select * from zipcode where dong like '%" + dong + "%'";
			st = con.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				ZipCodeVO zip = new ZipCodeVO();
				zip.setZipcode(rs.getString("zipcode"));
				zip.setSido(rs.getString("sido"));
				zip.setGugun(rs.getString("gugun"));
				zip.setDong(rs.getString("dong"));
				zip.setBunji(rs.getString("bunji"));
				z_arr.add(zip);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(rs, null, st, con);
		}

		return z_arr;
	}

	// 전체 보기 개수
	@Override
	public int getCount() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select count(*) from address";
		int count = 0;

		try {
			con = getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next())
				count = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(rs, null, st, con);
		}

		return count;
	}

	@Override
	public int getCount(String field, String word) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select count(*) from address where " + field + " like '%" + word + "%'";
		int count = 0;

		try {
			con = getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next())
				count = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(rs, null, st, con);
		}

		return count;
	}

}
