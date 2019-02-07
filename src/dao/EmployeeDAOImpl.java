package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import domain.EmployeeDTO;
import enums.EmployeeSQL;
import enums.Vendor;
import factory.DatabaseFactory;

public class EmployeeDAOImpl implements EmployeeDAO{
	
	private static EmployeeDAOImpl instance = new EmployeeDAOImpl();
	private EmployeeDAOImpl(){dao = EmployeeDAOImpl.getInstance();}
	public static EmployeeDAOImpl getInstance() {
	return instance;
	}
	EmployeeDAOImpl dao;
	
	@Override
	public void insertEmployee(EmployeeDTO emp) {
		try {
			System.out.println("daoimpl 진입!!!");
			String sql = EmployeeSQL.REGISTER.toString();
			System.out.println("sql===="+sql);
			Connection conn = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			System.out.println("sql2===="+sql);
			pstmt.setString(1, emp.getManager());
			pstmt.setString(2, emp.getName());
			pstmt.setString(3, emp.getBirthDate());
			pstmt.setString(4, emp.getPhoto());
			pstmt.setString(5, emp.getNotes());
			int rs = pstmt.executeUpdate();
		System.out.println((rs==1) ? "입력 성공":"입력 실패");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<EmployeeDTO> selectEmployeesList() {
		
		return dao.selectEmployeesList();
	}

	@Override
	public List<EmployeeDTO> selectEmployees(String searchWord) {
		
		return dao.selectEmployeesList();
	}

	@Override
	public EmployeeDTO selectEmployee(String searchWord) {
		
		return dao.selectEmployee(searchWord);
	}

	@Override
	public int countEmployees() {
		
		return countEmployees();
	}

	@Override
	public boolean existsEmployee(EmployeeDTO emp) {
		boolean ok = false;
		try {
			String sql = EmployeeSQL.ACCESS.toString();
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			ps.setString(1, emp.getEmployeeId());
			ps.setString(2, emp.getName());
			ResultSet rs = ps.executeQuery();
			if(rs.equals("name")){
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
	public void updateEmployee(EmployeeDTO emp) {
		
		
	}

	@Override
	public void deleteEmployee(EmployeeDTO emp) {
		
		
	}

}
