package in.nit.service;

import java.util.List;

import in.nit.model.Student;

public interface IStudentService {

	public Integer saveStudent(Student s);
	public List<Student> getAllStudents();
	public boolean removeOneStudent(Integer id);
	public Student getOneStudent(Integer id);
	public boolean updateStudent(Student s);
}
