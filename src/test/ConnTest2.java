package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import enums.EmployeeSQL;
import enums.Props;

public class ConnTest2 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{ //DB 안 오라클
			Class.forName(Props.ORA_DRIVER.getValue());
			conn = DriverManager.getConnection(
					Props.DB_URL.getValue(), 
					Props.DB_USER.getValue(), 
					Props.DB_PASS.getValue()); //url주소는 DB의 Oracle 프로퍼티에 있다.
			pstmt = conn.prepareStatement("SELECT NAME FROM EMPLOYEES WHERE EMPLOYEE_ID LIKE ?");
			rs = pstmt.executeQuery();			
			String name2 = "";
			while(rs.next()){
				name2 = rs.getString("NAME"); //컬럼은 cmd에서 테이블 만들며 썼던 name, id, ssn, pass 이런것.
			} //rs에 값이 있으면 true, 없으면 false
			System.out.println("회원의 이름2: "+name2);
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			try {
				conn.close();//커넥션을 끊어주는것.
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
	}
}
