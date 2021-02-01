package in.nit.validator;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.nit.db.DbConn;

public class UserValidator {

	public static boolean validateUser(String un,String pwd) {
		boolean flag=false;
		String sql=" SELECT COUNT(cid) FROM clienttab WHERE cid=? and csecr=?";
		try {
			PreparedStatement pstmt=DbConn.getConn().prepareStatement(sql);
			pstmt.setString(1, un);
			pstmt.setString(2, pwd);
			
			ResultSet rs=pstmt.executeQuery();
			rs.next();
			long count=rs.getLong(1);
			if(count>0) flag=true; //user exist
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public static String getRoleByUser(String un) {
		String role=null;
		String sql=" SELECT CROLE FROM CLIENTTAB WHERE CID=? ";
		try {
			PreparedStatement pstmt=DbConn.getConn().prepareStatement(sql);
			pstmt.setString(1, un);
			
			ResultSet rs=pstmt.executeQuery();
			rs.next();
			role=rs.getString(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return role;
	}
}


