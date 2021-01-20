package in.nit.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConn {

	private static Connection conn=null;
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:ORCL", 
					"scott", "tiger");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConn() {
		return conn;
	}
}



