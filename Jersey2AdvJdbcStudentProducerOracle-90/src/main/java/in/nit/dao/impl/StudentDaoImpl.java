package in.nit.dao.impl;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.nit.dao.IStudentDao;
import in.nit.db.DbConn;
import in.nit.model.Student;

public class StudentDaoImpl implements IStudentDao {

	@Override
	public Integer saveStudent(Student s) {
		String sql=" INSERT INTO STUDENTS VALUES(?,?,?,?,?) ";
		int count=0;
		try {
			PreparedStatement pstmt=DbConn.getConn().prepareStatement(sql);

			pstmt.setInt(1, s.getStdId());
			pstmt.setString(2, s.getStdName());
			pstmt.setString(3, s.getStdCourse());
			pstmt.setDouble(4, s.getStdFee());
			pstmt.setDouble(5, s.getStdDiscount());

			count=pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Student> getAllStudents() {
		String sql=" SELECT * FROM STUDENTS ";
		List<Student> list=null;
		try {
			PreparedStatement pstmt=DbConn.getConn().prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			list=new ArrayList<>();
			while(rs.next()) {
				list.add(new Student(
						rs.getInt("sid"), 
						rs.getString("sname"), 
						rs.getString("scourse"), 
						rs.getDouble("sfee"), 
						rs.getDouble("sdiscount") )
						);
				/*
				//a.Read data from ResultSet row
				int stdId=rs.getInt("sid");
				String stdName=rs.getString("sname");
				String stdCourse=rs.getString("scourse");
				double stdFee=rs.getDouble("sfee");
				double stdDiscount=rs.getDouble("sdiscount");

				//b.convert data into one Student class object
				Student s=new Student();
				s.setStdId(stdId);
				s.setStdName(stdName);
				s.setStdCourse(stdCourse);
				s.setStdFee(stdFee);
				s.setStdDiscount(stdDiscount);

				//c. add student class object to list
				list.add(s);
				 */
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	@Override
	public boolean removeOneStudent(Integer id) {
		String sql=" DELETE FROM STUDENTS WHERE SID = ? ";
		boolean deleted=false;
		try {
		
			PreparedStatement pstmt=DbConn.getConn().prepareStatement(sql);
			pstmt.setInt(1, id);
			
			deleted=pstmt.executeUpdate()>0?true:false;
		} catch (Exception e) {
			deleted=false;
			e.printStackTrace();
		}
		return deleted;
	}
	
	@Override
	public Student getOneStudent(Integer id) {
		Student s=null;
		String sql=" SELECT * FROM STUDENTS WHERE SID = ? ";
		try {
			PreparedStatement pstmt=DbConn.getConn().prepareStatement(sql);
			pstmt.setInt(1, id);
			
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				s=new Student(
						rs.getInt("sid"), 
						rs.getString("sname"), 
						rs.getString("scourse"), 
						rs.getDouble("sfee"), 
						rs.getDouble("sdiscount")
						);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
	@Override
	public boolean updateStudent(Student s) {
		boolean status=false;
		String sql= " UPDATE STUDENTS "
				+ "  SET SNAME=?,SCOURSE=?,SFEE=?,SDISCOUNT=? "
				+ "  WHERE SID=? ";
		try {
			
			PreparedStatement pstmt=DbConn.getConn().prepareStatement(sql);
			pstmt.setString(1, s.getStdName());
			pstmt.setString(2, s.getStdCourse());
			pstmt.setDouble(3, s.getStdFee());
			pstmt.setDouble(4, s.getStdDiscount());
			pstmt.setInt(5, s.getStdId());
			
			status=pstmt.executeUpdate()>0?true:false;
		} catch (Exception e) {
			status=false;
			e.printStackTrace();
		}
		return status;
	}
	
}





