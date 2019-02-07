package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import domain.CustomerDTO;
import enums.EmployeeSQL;
import enums.Vendor;
import factory.DatabaseFactory;

public class CustomerDAOImpl implements CustomerDAO{
	
	private static CustomerDAOImpl instance = new CustomerDAOImpl();
	private CustomerDAOImpl(){}
	public static CustomerDAOImpl getInstance() {
		return instance;
	}
	CustomerDAOImpl dao;

	@Override
	public void insertCustomer(CustomerDTO cus) {
		try {
			System.out.println("daoimpl 진입!!!");
			String sql = EmployeeSQL.SIGNUP.toString();
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			System.out.println(sql);
			ps.setString(1, cus.getCustomerID());
			ps.setString(2, cus.getCustomerName());
			ps.setString(3, cus.getAddress());
			ps.setString(4, cus.getCity());
			ps.setString(5, cus.getPostalCode());
			ps.setString(6, cus.getSsn());
			ps.setString(7, cus.getPassword());
			int rs = ps.executeUpdate();
			System.out.println((rs==1) ? "입력 성공":"입력 실패");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<CustomerDTO> selectCustomerList() {
		
		return dao.selectCustomerList();
	}

	@Override
	public List<CustomerDTO> selectCustomers(String searchWord) {
		
		return dao.selectCustomers(searchWord);
	}

	@Override
	public CustomerDTO selectCustomer(String searchWord) {
		
		return dao.selectCustomer(searchWord);
	}

	@Override
	public int countCustomer() {
		
		return countCustomer();
	}

	@Override
	public boolean existsCustomer(CustomerDTO cus) {
		boolean ok = false;
		try {
			String sql = EmployeeSQL.SIGNIN.toString();
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			ps.setString(1, cus.getCustomerID());
			ps.setString(2, cus.getPassword());
			ResultSet rs = ps.executeQuery();
			while (rs.equals("id")) {
				ok = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ok;
	}

	@Override
	public void updateCustomer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCustomer() {
		// TODO Auto-generated method stub
		
	}

}
