package in.nit.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import in.nit.model.Student1;



public class ObjectToJsonTest {
//Serialize
	public static void main(String[] args) {
		
		try {
			
			  //1.Model class Object 
			Student1 s=new Student1();
			s.setStdId(101);
			s.setStdName("Sankar");
			s.setStdFee(34.89);
			s.setStdCource("Web Services");
			  
			  //2.Create Gson class Object 
			  Gson g=new GsonBuilder() 
				.excludeFieldsWithoutExposeAnnotation()
			  .create(); 
			  //3.call toJson() method
			  String json=g.toJson(s);
			  
			  //4.print Gson String 
			  System.out.println(json); 
			 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
