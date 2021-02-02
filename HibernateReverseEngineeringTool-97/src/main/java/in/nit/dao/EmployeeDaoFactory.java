package in.nit.dao;

public class EmployeeDaoFactory {

	public static EmployeeDao getInstane() {
		
		return new EmployeeDaoImpl();
	}
}
