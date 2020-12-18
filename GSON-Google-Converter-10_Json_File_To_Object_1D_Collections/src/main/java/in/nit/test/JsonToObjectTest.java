package in.nit.test;

import java.io.FileReader;
import java.io.Reader;

import com.google.gson.Gson;

import in.nit.model.Employee;

public class JsonToObjectTest {

	public static void main(String[] args) {
		try {
//1.create File Reader Object
		Reader r=new FileReader("g.json");
		//2.Create Gson class Object
		Gson g=new Gson();
		//3.Call toJson() method 
		Employee e=g.fromJson(r,Employee.class);
		
		//4.print Gson String
		System.out.println(e);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
