package in.nit.test;
import java.io.FileWriter;
import java.io.Writer;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import in.nit.model.Address;
import in.nit.model.Employee;



public class ObjectToJsonTestAndFile {
//Serialize
	public static void main(String[] args) {
		
		try {
			
			  //1.Model class Object 
			Address a=new Address();
			a.setHno(230);
			a.setLoc("hyd");
			Employee e=new Employee();
			e.setEmpId(294);
			e.setEmpName("Sankar");
			e.setAdd(a);//HAS-A
			//JDK9
			e.setProjects(List.of("p1","p2","p3","p4"));
			e.setVarsions(Map.of("p1","v1","p2","v2","p3","v3"));
			
			  
			  //2.Create Gson class Object 
			  Gson g=new GsonBuilder() 
					  .setPrettyPrinting()
					  .serializeNulls()//show null values
					  .create();
			 
			  //3.call toJson() method
			  String json=g.toJson(e);
			  
			  //4.print Gson String 
			  System.out.println(json); 
			 //Write Same Date To file
			  Writer w=new FileWriter("s.json");
			  g.toJson(e,w);
			  System.out.println("Done");
			  w.close();
			  
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
