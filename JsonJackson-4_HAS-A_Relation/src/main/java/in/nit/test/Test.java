package in.nit.test;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.nit.model.Model;
import in.nit.model.Product;

public class Test {

	public static void main(String[] args) {
		try {
			
				Model m=new Model();
				m.setMId(101);
				m.setMCode("ABC");
			Product p=new Product();
			p.setPId(102);
			p.setPNmae("Sankar");
			p.setMob(m);//link
			
			ObjectMapper om=new ObjectMapper();
			String json=om.writeValueAsString(p);
			System.out.println(json);
			
		} catch (Exception e) {
		}

	}

}



