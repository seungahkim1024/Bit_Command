package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.ProductDTO;
import enums.ProductSQL;
import enums.Vendor;
import factory.DatabaseFactory;
import proxy.Proxy;

public class ProductDAOImpl implements ProductDAO{

	private static ProductDAOImpl instance = new ProductDAOImpl();
	private ProductDAOImpl(){} 
	public static ProductDAOImpl getInstance() {
		return instance;
	}

	
	@Override
	public void insertProduct(ProductDTO pro) {
		try {
			String sql = "";
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			ps.setString(1, "");
			int rs = ps.executeUpdate();
			System.out.println((rs==1) ? "입력성공" : "입력실패");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public List<ProductDTO> selectAllProductList(Proxy pxy) {
		List<ProductDTO> list = new ArrayList<>();
		try {
			String sql = "SELECT * FROM PRODUCTS";
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ProductDTO pro = null;
			while(rs.next()){
				pro = new ProductDTO();
				pro.setPrice(rs.getString("PRICE"));
				pro.setProductId(rs.getString("PRODUCT_ID"));
				pro.setProductName(rs.getString("PRODUCT_NAME"));
				pro.setSupplierId(rs.getString("SUPPLIER_ID"));
				pro.setUnit(rs.getString("UNIT"));
				pro.setCategoryId(rs.getString("CATEGORY_ID"));
				list.add(pro);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	@Override
	public List<ProductDTO> selectProducts(Proxy pxy) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ProductDTO selectProduct(ProductDTO pro) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int countProduct(Proxy pxy) {
		int count = 0;
		try {
			String sql = ProductSQL.PRO_COUNT.toString();
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				count = rs.getInt("COUNT");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("프로덕트 DAO 카운트 === "+count);
		return count;
	}
	@Override
	public boolean existProduct(ProductDTO pro) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void updateProduct(ProductDTO pro) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteProduct(ProductDTO pro) {
		// TODO Auto-generated method stub
		
	}
	
	
}
