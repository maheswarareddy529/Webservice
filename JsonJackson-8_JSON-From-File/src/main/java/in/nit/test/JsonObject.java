package in.nit.test;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.nit.model.Product;
public class JsonObject {

	

  public static void main(String[] args) {
		try {
			File f=new File("prods.json");//prods.json
			Product p=new Product();
			ObjectMapper om=new ObjectMapper();
			p=om.readValue(f,Product.class);
			System.out.println(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
}



