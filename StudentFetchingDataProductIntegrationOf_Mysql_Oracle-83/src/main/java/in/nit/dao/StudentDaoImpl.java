package in.nit.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.nit.db.DBConn;
import in.nit.model.Student;

public class StudentDaoImpl implements IStudentDao {
//1.Fetching Data From Database
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
			while(rs.next()) {
				list.add(new Student(
						rs.getInt("sid"),
						rs.getString("sname"),
						rs.getString("scourse"),
						rs.getDouble("sfee"),
						rs.getDouble("sdiscount")
						));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
}
