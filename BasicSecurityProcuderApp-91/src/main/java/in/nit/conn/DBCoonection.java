package in.nit.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBCoonection {
private static Connection conn=null;
static {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
	} catch (Exception e) {
	e.printStackTrace();
	}
}
public static Connection getConn() {
	
	return conn;
}
}
