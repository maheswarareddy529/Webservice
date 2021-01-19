package in.nit.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.DbDoc;

import in.nit.db.DBConn;
import in.nit.model.Student;

public class StudentDaoImpl implements IStudentDao {
	//1. Update Data on  Database based on ID
	@Override
	public Integer saveStudent(Student s) {
		String query="INSERT INTO STUDENTS VALUES(?,?,?,?,?)";
		int count=0;
		try {
			PreparedStatement ps=DBConn.getConnection().prepareStatement(query);
			ps.setInt(1,s.getStdId());
			ps.setString(2,s.getStdName());
			ps.setString(3,s.getStdCource());
			ps.setDouble(4,s.getStdFee());
			ps.setDouble(5,s.getStdDiscount());
			count=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Student> getAllStudents() {
		String query="SELECT * FROM STUDENTS";
		List<Student> list=null;
		try {
			PreparedStatement ps=DBConn.getConnection().prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			list=new ArrayList<>();

			/*    while(rs.next()) { 
			   list.add(new Student(
			    rs.getInt("sid"),
			   rs.getString("sname"), 
			   rs.getString("scourse"), 
			   rs.getDouble("sfee"),
			   rs.getDouble("sdiscount") ));
			    }*/
			//a.Read Data From ResultSet Row
			while(rs.next()) {
				Integer stdId=rs.getInt("sid");
				String stdName=rs.getString("sname");
				String stdCourse=rs.getString("scourse");
				Double stdFee=rs.getDouble("sfee");
				Double stdDiscount=rs.getDouble("sdiscount");

				//b. Convert Data into One Student Class Object
				Student s=new Student();
				s.setStdId(stdId);
				s.setStdName(stdName);
				s.setStdCource(stdCourse);
				s.setStdFee(stdFee);
				s.setStdDiscount(stdDiscount);

				//c.Add Student class Object List
				list.add(s);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		return list;
	}

	@Override
	public boolean removeOneStudent(Integer id) {
		String query="DELETE FROM STUDENTS WHERE SID=?";
		boolean deleted=false;
		try {
			PreparedStatement ps=DBConn.getConnection().prepareStatement(query);
			ps.setInt(1,id);
			deleted=ps.executeUpdate()>0?true:false;
		}
		catch(Exception e) {
			deleted=false;
			e.printStackTrace();
		}
		return deleted;
	}

	@Override
	public Student getOneStudent(Integer id) {
		Student s=null;
		String query="SELECT * FROM STUDENTS WHERE SID=?";
		try {
			PreparedStatement ps=DBConn.getConnection().prepareStatement(query);
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				s=new Student(
						rs.getInt("sid"),
						rs.getString("sname"),
						rs.getString("scourse"),
						rs.getDouble("sfee"),
						rs.getDouble("sdiscount")
						);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public boolean updateStudent(Student s) {
		boolean status=false;
		String query="UPDATE STUDENTS SET SNAME=?,SCOURSE=?,SFEE=?,SDISCOUNT=? WHERE SID=?";
		try {
			PreparedStatement ps=DBConn.getConnection().prepareStatement(query);
			ps.setString(1,s.getStdName());
			ps.setString(2, s.getStdCource());
			ps.setDouble(3,s.getStdFee());
			ps.setDouble(4,s.getStdDiscount());
			ps.setInt(5, s.getStdId());
			status=ps.executeUpdate()>0?true:false;
		} catch (Exception e) {
			status=false;
			e.printStackTrace();
		}
		return status;
	}


}
