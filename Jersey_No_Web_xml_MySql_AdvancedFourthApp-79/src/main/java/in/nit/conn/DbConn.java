package in.nit.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConn {
private static Connection con=null;
static {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/webservices","root","root");
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
public static Connection getCon() {
	
	return con;
}
}
