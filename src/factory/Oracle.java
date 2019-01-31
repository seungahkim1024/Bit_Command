package factory;

import java.sql.Connection;
import java.sql.DriverManager;

import enums.Props;
import lombok.Data;
@Data
public class Oracle implements Database{
	private Connection Connect;
	private String deriver, url, user, password;

	@Override
	public Connection getConnection() {
		//oracle.jdbc.OracleDriver
		Connection connec = null;
		try {
			Class.forName(Props.ORA_DRIVER.getValue());
			connec = DriverManager.getConnection(
					Props.DB_URL.getValue(), 
					Props.DB_USER.getValue(), 
					Props.DB_PASS.getValue());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connec ;
	}
}
