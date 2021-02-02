package in.nit.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.nit.domain.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public int save(Employee emp) {
		Transaction tx=null;
		int id=0;
		//create hibernate SessionFactory, Session Objects
		Session ses=new Configuration().configure("/in/nit/cfgs/hibernate.cfg.xml").buildSessionFactory().openSession();
		tx=ses.beginTransaction();
		
		//Save Object 
		try {
			id=(Integer)ses.save(emp);
			tx.commit();
		}
		catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return id;
	}

}
