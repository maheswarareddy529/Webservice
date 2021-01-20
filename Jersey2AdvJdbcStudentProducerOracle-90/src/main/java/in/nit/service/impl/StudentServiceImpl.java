package in.nit.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;

import in.nit.dao.IStudentDao;
import in.nit.model.Student;
import in.nit.service.IStudentService;

public class StudentServiceImpl implements IStudentService {
	@Inject
	private IStudentDao dao;//HAS-A

	@Override
	public Integer saveStudent(Student s) {
		//calculations
		double fee=s.getStdFee();
		double disc=fee * 10/100.0;
		s.setStdDiscount(disc);
		//calling DAL
		return dao.saveStudent(s);
	}


	@Override
	public List<Student> getAllStudents() {
		List<Student> list=dao.getAllStudents();
		//Collections.sort(list,(o1,o2)->o1.getStdId()-o2.getStdId()); //ID-ASC
		Collections.sort(list,(o1,o2)->o2.getStdId()-o1.getStdId()); //ID-DESC
		//Collections.sort(list,(o1,o2)->o1.getStdName().compareTo(o2.getStdName())); //NAME-ASC
		//Collections.sort(list,(o1,o2)->o2.getStdName().compareTo(o1.getStdName())); //NAME-DESC

		Collections.sort(list,new Comparator<Student>() {
			public int compare(Student o1, Student o2) {
				return o2.getStdId()-o1.getStdId();
			}
		});

		return list;
	}


	@Override
	public boolean removeOneStudent(Integer id) {
		return dao.removeOneStudent(id);
	}

	@Override
	public Student getOneStudent(Integer id) {
		return dao.getOneStudent(id);
	}

	@Override
	public boolean updateStudent(Student s) {
		//calculations
		double fee=s.getStdFee();
		double disc=fee * 10/100.0;
		s.setStdDiscount(disc);
		//calling DAL
		return dao.updateStudent(s);
	}
}




