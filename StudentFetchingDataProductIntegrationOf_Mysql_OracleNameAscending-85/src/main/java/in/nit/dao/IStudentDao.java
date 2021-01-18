package in.nit.dao;

import java.util.List;

import in.nit.model.Student;

public interface IStudentDao {
public Integer saveStudent(Student s);
public List<Student> getAllStudents();
}
