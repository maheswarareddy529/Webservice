package in.nit.service.impl;

import java.util.Collections;
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
		//Calculations
		Double fee=s.getStdFee();
		Double dis=fee*10/100.0;
		s.setStdDiscount(dis);
		//Calling Data Access layer(DAL)
		
		return dao.saveStudent(s);
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> list=dao.getAllStudents();
		Collections.sort(list, (o1,o2)->
		o1.getStdId()-o2.getStdId()
				);//ID-ASC
		return list;
	}
	
}
