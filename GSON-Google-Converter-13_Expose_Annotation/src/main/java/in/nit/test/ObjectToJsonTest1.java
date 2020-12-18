package in.nit.test;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import in.nit.model.Student1;



public class ObjectToJsonTest1 {
//deserialize
	public static void main(String[] args) {
		
		try {
			
			  //1.String JSON
			String json="{\"stdId\":202,\"stdName\":\"Sankar\",\"stdFee\":23.98,\"stdCource\":\"Java\"}";
			
			  
			  //2.Create Gson class Object 
			  Gson g=new GsonBuilder() .excludeFieldsWithoutExposeAnnotation() .create();
			  //3.call toJson() method
			  Student1 s=g.fromJson(json, Student1.class);
			  
			  //4.print Gson String 
			  System.out.println(s); 
			 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
