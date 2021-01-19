package in.nit.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.nit.db.DBConn;
import in.nit.model.Student;

public class StudentDaoImpl implements IStudentDao {
	//1.Remove Data From Database based one ID
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


}
