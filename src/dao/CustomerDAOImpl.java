package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.CustomerDTO;
import domain.ImageDTO;
import enums.CustomersSQL;
import enums.Vendor;
import factory.DatabaseFactory;
import proxy.ImageProxy;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;

public class CustomerDAOImpl implements CustomerDAO{
	
	private static CustomerDAOImpl instance = new CustomerDAOImpl();
	Connection conn;
	private CustomerDAOImpl(){
		conn = DatabaseFactory
				.createDatabase(Vendor.ORACLE)
				.getConnection();
	}
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
	public List<CustomerDTO> selectCustomerList(Proxy pxy) {
		List<CustomerDTO> list = new ArrayList<>();
		try {
			Pagination page =  ((PageProxy)pxy).getPage();
			String sql = CustomersSQL.LIST.toString();
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			ps.setString(1, String.valueOf(page.getStartRow()));
			ps.setString(2, String.valueOf(page.getEndRow()));
			ResultSet rs = ps.executeQuery();
			CustomerDTO cus = null;
			while(rs.next()){
				cus = new CustomerDTO();
				cus.setNo(rs.getString("RNUM"));
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
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<CustomerDTO> selectCustomers(Proxy pxy) {
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
		return dao.selectCustomers(pxy);
	}

	@Override
	public CustomerDTO selectCustomer(CustomerDTO cus) {
		CustomerDTO temp = null;
		try {
			String sql = (cus.getPassword() == null) ?
				 CustomersSQL.CUS_RETRIEVE.toString() :
				 CustomersSQL.SIGNIN.toString();	
			PreparedStatement ps = DatabaseFactory
					.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(sql);
			//ps.setString(1, cus.getCustomerID());
			if(cus.getPassword()==null) {
				ps.setString(1, cus.getCustomerID());
			}else {
				ps.setString(1, cus.getCustomerID());
				ps.setString(2, cus.getPassword());
			}
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				temp = new CustomerDTO();
				temp.setAddress(rs.getString("ADDRESS"));
				temp.setCity(rs.getString("CITY"));
				temp.setCustomerID(rs.getString("CUSTOMER_ID"));
				temp.setCustomerName(rs.getString("CUSTOMER_NAME"));
				temp.setPassword(rs.getString("PASSWORD"));
				temp.setPostalCode(rs.getString("POSTAL_CODE"));
				temp.setSsn(rs.getString("SSN"));

			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return temp;
	}

	@Override
	public int countCustomer(Proxy pxy) {
		int count = 0;
		try {
			String sql = CustomersSQL.ROW_COUNT.toString();
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
		System.out.println("총 고객수: "+count);
		return count;
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
	public void updateCustomer(CustomerDTO cus) {
		
		try {
			String sql = CustomersSQL.UPDATE.toString();
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			ps.setString(1, cus.getPhone());
			ps.setString(2, cus.getCity());
			ps.setString(3, cus.getAddress());
			ps.setString(4, cus.getPostalCode());
			ps.setString(5, cus.getPassword());
			ps.setString(6, cus.getCustomerID());
			int rs = ps.executeUpdate();
			System.out.println((rs==1) ? "입력 성공":"입력 실패");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	public void deleteCustomer(CustomerDTO cust) {
		try {
			String sql = CustomersSQL.DELETE_CUST.toString();
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			ps.setString(1, cust.getCustomerID());
			int rs = ps.executeUpdate();
			System.out.println((rs==1) ? "입력성공" : "입력실패");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Map<String, Object> selectPhone(Proxy pxy) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String sql = CustomersSQL.PHONE.toString();
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			CustomerDTO cus = null;
			while(rs.next()){ //while은 이터레이터(rs.next()는 이터레이터 패턴!) 쓸 때, for는 loop 돌 때!
				cus = new CustomerDTO();
				String entry = rs.getString("CUSTOMER_ID");
				cus.setCustomerID(rs.getString("CUSTOMER_ID"));
				cus.setCustomerName(rs.getString("CUSTOMER_NAME"));
				cus.setPhone(rs.getString("PHONE"));
				map.put(entry, cus);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	public Map<String, Object> selectProfile(Proxy pxy) {
		System.out.println("커스토머디티오 셀렉트 프로필 진입!");
		Map<String, Object> map = new HashMap<>();
		CustomerDTO cus = new CustomerDTO();
		ImageDTO img = new ImageDTO();
		try {
			ImageProxy ipxy = (ImageProxy) pxy; //사진 들어왔어!
			System.out.println("DAO 넘어온 파일명: "+ipxy.getImg().getImgName());
			System.out.println("DAO 넘어온 확장자: "+ipxy.getImg().getImgExtention());
			System.out.println("DAO 넘어온 오너: "+ipxy.getImg().getOwner());
			ImageDAOImpl
			.getInstance()
			.insertImage(ipxy.getImg()); //이미지DAO에 사진 보내서 DB에 저장!

			String imgSeq = ImageDAOImpl
							.getInstance()
							.lastimageSeq();//DB에 저장한 이미지 SEQ 불러옴!
			System.out.println("imgseq는: "+imgSeq);
			String customerID = ipxy.getImg().getOwner();
			String sql = CustomersSQL.UPDATE_PROFILE_IMG.toString();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, imgSeq);
			ps.setString(2, customerID);
			ps.executeUpdate();
			img.setImgSeq(imgSeq);
			img = ImageDAOImpl
					.getInstance()
					.selectimage(img);
			cus.setCustomerID(customerID);
			cus = selectCustomer(cus);
			System.out.println("회원정보: "+cus.toString());
			System.out.println("이미지정보: "+img.toString());
			map.put("cus", cus);
			map.put("img", img);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
}
