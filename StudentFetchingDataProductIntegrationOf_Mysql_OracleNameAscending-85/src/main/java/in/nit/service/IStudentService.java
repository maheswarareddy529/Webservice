package in.nit.service;

import java.util.List;

import in.nit.model.Student;

public interface IStudentService {
public Integer saveStudent(Student s);
public List<Student> getAllStudents();
}
