package in.nit.test;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.nit.model.Address;
import in.nit.model.Employee;

public class Test {

	public static void main(String[] args) {
		try {
			
				Address a=new Address();
				a.setHNo("2-62");
				a.setHLoc("Razole");
				
				Employee e=new Employee();
				e.setEId(101);
				e.setENmae("Sankar");
			    e.setEAdd(a);//link
			ObjectMapper om=new ObjectMapper();
			String json=om.writeValueAsString(e);
			System.out.println(json);
			
		} catch (Exception e) {
		}

	}

}



