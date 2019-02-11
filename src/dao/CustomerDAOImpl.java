package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.regexp.internal.recompile;

import domain.CustomerDTO;
import enums.CustomersSQL;
import enums.EmployeeSQL;
import enums.Vendor;
import factory.DatabaseFactory;

public class CustomerDAOImpl implements CustomerDAO{
	
	private static CustomerDAOImpl instance = new CustomerDAOImpl();
	private CustomerDAOImpl(){ dao = CustomerDAOImpl.getInstance();}
	public static CustomerDAOImpl getInstance() {
		return instance;
	}
	CustomerDAOImpl dao;

	@Override
	public void insertCustomer(CustomerDTO cus) {
		try {
			System.out.println("daoimpl 진입!!!");
			String sql = CustomersSQL.SIGNUP.toString();
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			System.out.println(sql);
			ps.setString(1, cus.getCustomerID());
			ps.setString(2, cus.getPassword());
			ps.setString(3, cus.getCustomerName());
			ps.setString(4, cus.getSsn());
			ps.setString(5, cus.getAddress());
			ps.setString(6, cus.getCity());
			ps.setString(7, cus.getPostalCode());
			int rs = ps.executeUpdate();
			System.out.println((rs==1) ? "입력 성공":"입력 실패");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<CustomerDTO> selectCustomerList() {
		List<CustomerDTO> list = new ArrayList<>();
		try {
			String sql = CustomersSQL.LIST.toString();
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			CustomerDTO cus = null;
			while(rs.next()){
				cus = new CustomerDTO();
				cus.setAddress(rs.getString("ADDRESS"));
				cus.setCity(rs.getString("CITY"));
				cus.setCustomerID(rs.getString("CUSTOMER_ID"));
				cus.setCustomerName(rs.getString("CUSTOMER_NAME"));
				cus.setPassword(rs.getString("PASSWORD"));
				cus.setPhone(rs.getString("PHONE"));
				cus.setPhoto(rs.getString("PHOTO"));
				cus.setPostalCode(rs.getString("POSTAL_CODE"));
				cus.setSsn(rs.getString("SSN"));
				list.add(cus);
				System.out.println("방금담은 값: "+rs.getString("CUSTOMER_NAME"));
			}
			System.out.println("1번회원 : "+rs.getString("CUSTOMER_NAME"));
			System.out.println("2번회원 : "+rs.getString("CUSTOMER_NAME"));
			System.out.println("3번회원 : "+rs.getString("CUSTOMER_NAME"));
			System.out.println("4번회원 : "+rs.getString("CUSTOMER_NAME"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<CustomerDTO> selectCustomers(String searchWord) {
		try {
			String sql = "";
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dao.selectCustomers(searchWord);
	}

	@Override
	public CustomerDTO selectCustomer(CustomerDTO cus) {
		CustomerDTO temp = null;
		System.out.println("셀렉트커스토머 입장!!");
		try {
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(CustomersSQL.SIGNIN.toString());
			ps.setString(1, cus.getCustomerID());
			ps.setString(2, cus.getPassword());
			ResultSet rs = ps.executeQuery();
			System.out.println("daoImpl===="+cus.getCustomerID());
			while (rs.next()) {
				temp = new CustomerDTO();
				temp.setAddress("ADDRESS");
				temp.setCity("CITY");
				temp.setCustomerID("CUSTOMER_ID");
				temp.setCustomerName("CUSTOMER_NAME");
				temp.setPassword("PASSWORD");
				temp.setPostalCode("POSTAL_CODE");
				temp.setSsn("SSN");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return temp;
	}

	@Override
	public int countCustomer() {
		try {
			String sql = "";
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return countCustomer();
	}

	@Override
	public boolean existsCustomerID(CustomerDTO cus) {
		boolean ok = false;
		try {
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(CustomersSQL.SIGNIN.toString());
			ps.setString(1, cus.getCustomerID());
			ps.setString(2, cus.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				ok = true;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("접근허용= "+ok);
		return ok;
	}

	@Override
	public void updateCustomer() {
		try {
			String sql = "";
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			ps.setString(1, "");
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	public void deleteCustomer() {
		try {
			String sql = "";
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			ps.setString(1, "");
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
