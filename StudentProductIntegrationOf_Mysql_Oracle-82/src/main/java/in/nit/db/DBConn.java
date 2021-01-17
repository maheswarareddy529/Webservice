package in.nit.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
private static Connection conn=null;

static {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/webservices","root","root");
	} catch (Exception e) {
	e.printStackTrace();
	}
}
public static Connection getConnection() {
	
	return conn;
}
}
