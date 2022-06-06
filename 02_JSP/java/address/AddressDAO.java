package com.address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//SQL 
public class AddressDAO {

	private static AddressDAO instance;

	public static AddressDAO getInstance() {
		if (instance == null) {
			instance = new AddressDAO();
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

	// close
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

	// address insert
	public void addrInsert(Address ad) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConnection();
			String sql = "insert into address values(address_seq.nextval,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, ad.getName());
			ps.setString(2, ad.getAddr());
			ps.setString(3, ad.getZipcode());
			ps.setString(4, ad.getTel());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(null, ps, null, con);
		}
	}

	// address list
	// 검색 포함 list
	public ArrayList<Address> addrList(String field, String word) {

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Address> a_addr = new ArrayList<>();
		String sql = "";
		try {
			con = getConnection();

			// 검색 여부 구분
			if (word.equals(""))
				sql = "select * from address";
			else
				sql = "select * from address where " + field + " like '%" + word + "%'";

			st = con.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				Address ad = new Address();
				ad.setNum(rs.getInt("num"));
				ad.setName(rs.getString("name"));
				ad.setAddr(rs.getString("addr"));
				ad.setZipcode(rs.getString("zipcode"));
				ad.setTel(rs.getString("tel"));
				a_addr.add(ad);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(rs, null, st, con);
		}

		return a_addr;

	}

	// detail 상세 보기
	public Address detail(int num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		Address ad = new Address();

		try {
			con = getConnection();
			String sql = "select * from address where num =" + num;
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				ad.setNum(rs.getInt("num"));
				ad.setName(rs.getString("name"));
				ad.setAddr(rs.getString("addr"));
				ad.setZipcode(rs.getString("zipcode"));
				ad.setTel(rs.getString("tel"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(rs, null, st, con);
		}

		return ad;

	}

	// delete
	public void addrDelete(int num) {

		Connection con = null;
		Statement st = null;

		try {
			con = getConnection();
			String sql = "delete from address where num=" + num;
			st = con.createStatement();
			st.executeUpdate(sql);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(null, null, st, con);
		}

	}

	// address update
	public void addrUpdate(Address ad) {

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = getConnection();
			String sql = "update address set name=?, tel=?, zipcode=?, addr=? where num= ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, ad.getName());
			ps.setString(2, ad.getTel());
			ps.setString(3, ad.getZipcode());
			ps.setString(4, ad.getAddr());
			ps.setInt(5, ad.getNum());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(null, null, ps, con);
		}
	}

	public int getCount(String field, String word) {

		Connection con = null;
		Statement st = null;
		String sql = "";
		ResultSet rs = null;
		int count = 0;

		try {
			con = getConnection();
			st = con.createStatement();

			if (word.equals(""))
				sql = "select count(*) from address";
			else
				sql = "select count(*) from address where " + field + " like '%" + word + "%'";

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

	public ArrayList<Zipcode> zipcodeRead(String dong) {

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Zipcode> z_arr = new ArrayList<Zipcode>();

		try {
			con = getConnection();
			String sql = "select * from zipcode where dong like '%" + dong + "%'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			System.out.println(sql);
			while (rs.next()) {
				Zipcode zip = new Zipcode();
				zip.setZipcode(rs.getString("zipcode"));
				zip.setSido(rs.getString("sido"));
				zip.setGugun(rs.getString("gugun"));
				zip.setDong(rs.getString("dong"));
				zip.setBunji(rs.getString("bunji"));
				zip.setSeq(rs.getInt("seq"));
				z_arr.add(zip);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(rs, null, st, con);
		}

		return z_arr;
	}

}
