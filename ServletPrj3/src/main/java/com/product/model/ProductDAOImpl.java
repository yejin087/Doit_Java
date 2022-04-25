package com.product.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.util.DBCloseConnection;
import com.util.DBConnection;

public class ProductDAOImpl implements ProductDAO {
	private static ProductDAO instance = new ProductDAOImpl();

	public static ProductDAO getInstance() {

		return instance;
	}

	@Override
	public void productInsert(Product product) {

		Connection con = null;
		PreparedStatement ps = null;
		StringBuilder sb = new StringBuilder();
		sb.append("insert into product ");
		sb.append(
				"(p_productId, p_pname, p_unitPrice, p_description, p_category, p_manufacturer, p_unitInStock, p_condition, p_fileName)");
		sb.append(" values (product_seq.nextval,?,?,?,?,?,?,?,?)");

		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sb.toString());

			ps.setString(1, product.getPname());
			ps.setInt(2, product.getUnitPrice());
			ps.setString(3, product.getDescription());
			ps.setString(4, product.getCategory());
			ps.setString(5, product.getManufacturer());
			ps.setLong(6, product.getUnitInStock());
			ps.setString(7, product.getCondition());
			ps.setString(8, product.getFilename());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCloseConnection.closeConnection(null, ps, null, con);
		}

	}

	@Override
	public ArrayList<Product> productAllfind() {

		ArrayList<Product> p_arr = new ArrayList<>();
		String sql = "select * from product";

		try (Connection con = DBConnection.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);) {

			while (rs.next()) {
				Product product = new Product();
				product.setProductId(Integer.parseInt(rs.getString("p_productId")));
				product.setPname(rs.getString("p_pname"));
				product.setUnitPrice(Integer.parseInt(rs.getString("p_unitPrice")));
				product.setDescription(rs.getString("p_description"));
				product.setCategory(rs.getString("p_category"));
				product.setManufacturer(rs.getString("p_manufacturer"));
				product.setUnitInStock(Integer.parseInt(rs.getString("p_unitInStock")));
				product.setCondition(rs.getString("p_condition"));
				product.setFilename(rs.getString("p_fileName"));

				p_arr.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return p_arr;
	}

	@Override
	public Product findById(Long productId) {
		Product p = new Product();
		String sql = "select * from product where p_productId=" + productId;
		Product product = null;
		try (Connection con = DBConnection.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);) {

			if (rs.next()) {
				product = new Product();
				product.setProductId(Integer.parseInt(rs.getString("p_productId")));
				product.setPname(rs.getString("p_pname"));
				product.setUnitPrice(Integer.parseInt(rs.getString("p_unitPrice")));
				product.setDescription(rs.getString("p_description"));
				product.setCategory(rs.getString("p_category"));
				product.setManufacturer(rs.getString("p_manufacturer"));
				product.setUnitInStock(Integer.parseInt(rs.getString("p_unitInStock")));
				product.setCondition(rs.getString("p_condition"));
				product.setFilename(rs.getString("p_fileName"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return product;
	}

}
