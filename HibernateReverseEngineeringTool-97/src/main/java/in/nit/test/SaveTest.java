package in.nit.test;

import in.nit.dao.EmployeeDao;
import in.nit.dao.EmployeeDaoFactory;
import in.nit.domain.Employee;

public class SaveTest {

	public static void main(String[] args) {
		EmployeeDao dao=null;
		Employee emp=null;
		//get dao
		dao=EmployeeDaoFactory.getInstane();
       //invoke method
		emp=new Employee();
		emp.setId(2344478);
		emp.setName("Sankar");
		int eno=dao.save(emp);
		System.out.println("Record is Saved in Database" +eno);
	}

}
