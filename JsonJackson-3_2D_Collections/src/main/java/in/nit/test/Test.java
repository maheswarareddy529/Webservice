package in.nit.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.nit.model.Product;

public class Test {

	public static void main(String[] args) {
		try {
			
	
			Product p1=new Product();
			
			Map<String,String> map=new HashMap<>();
			map.put("m1", "RED"); map.put("m2", "BLUE"); map.put("m3", "GREEN");
			
			Properties p=new Properties();
			p.put("v1","3.2"); p.put("v2", "5.6");
			
			p1.setPId(101);
			p1.setPCode("abc");
			p1.setModels(map);
			p1.setInfo(p);
			
			ObjectMapper om=new ObjectMapper();
			String json=om.writeValueAsString(p1);
			System.out.println(json);
			
		} catch (Exception e) {
		}

	}

}



