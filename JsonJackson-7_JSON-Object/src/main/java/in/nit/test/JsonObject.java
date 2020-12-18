package in.nit.test;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.nit.model.Product;
public class JsonObject {

	

  public static void main(String[] args) {
		try {
			String json="{\"pid\":101,\"pcode\":\"ABC\",\"pcost\":343.00}";
			//String json="{}";
			//note double values ,float values .00f,.00d not allowed if you mention  you not get output
			Product p=new Product();
			ObjectMapper om=new ObjectMapper();
			p=om.readValue(json,Product.class);
			System.out.println(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
}



