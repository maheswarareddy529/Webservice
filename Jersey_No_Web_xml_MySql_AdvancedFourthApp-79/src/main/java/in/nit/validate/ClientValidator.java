package in.nit.validate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.nit.conn.DbConn;

public class ClientValidator {
public static boolean exist(String clientId,String secret) {
	String query="SELECT CID,CSER FROM CLIENTTAB WHERE CID=? AND CSER=?";
	boolean exist=false;
	try {
		PreparedStatement pt=DbConn.getCon().prepareStatement(query);
		pt.setString(1,clientId);
		pt.setString(2,secret);
		
		ResultSet rs=pt.executeQuery();
		if(rs.next()) {
			exist=true;
		}
	}
	catch(Exception e) {
		exist=false;
		e.printStackTrace();
	}
	return exist;
}
}
