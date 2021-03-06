package in.nit.validator;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.nit.conn.DBCoonection;

public class UserValidator {
public static boolean isUserExist(String un,String pwd) {
	boolean flag=false;
	String sql="SELECT COUNT(CID) FROM CLIENTTAB WHERE CID=? AND CSECR=?";
	try {
	PreparedStatement ps=DBCoonection.getConn().prepareStatement(sql);
     ps.setString(1, un);
     ps.setString(2, pwd);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			long count=rs.getLong(1);
			if(count>0)
				flag=true;// User Exist
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return flag;
}
}
