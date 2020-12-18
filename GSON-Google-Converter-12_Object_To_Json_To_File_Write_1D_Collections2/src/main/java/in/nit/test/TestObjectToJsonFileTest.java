package in.nit.test;

import java.io.FileWriter;
import java.io.Writer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import in.nit.model.Employee;

public class TestObjectToJsonFileTest {

	public static void main(String[] args) {
		//JDK 7 auto closeable+ try with resources.
		try(Writer writer=new  FileWriter("g.json")) {
			//1.Model class Object
			Employee e=new Employee();
			e.setEId(103);
			e.setEName("Sankar");
			e.setESal(34.88);
			
			//2.Create Gson class Object
			Gson g=new GsonBuilder()
					.setPrettyPrinting()
					.create();
			//3.Convert JSON to Store into File
			g.toJson(e,writer);
			
			//4.print Gson String
			System.out.println("Done");
			writer.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
