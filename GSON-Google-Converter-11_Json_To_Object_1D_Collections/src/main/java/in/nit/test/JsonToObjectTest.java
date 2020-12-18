package in.nit.test;

import com.google.gson.Gson;

import in.nit.model.Employee;

public class JsonToObjectTest {

	public static void main(String[] args) {
		try {
//1.Define JSON String 
		String json="{\"eId\":101,\"eName\":\"Sankar\",\"eSal\":22.33}";
		//2.Create Gson class Object
		Gson g=new Gson();
		//3.Convert JSON to Employee class
		Employee e=g.fromJson(json,Employee.class);
		
		//4.print Gson String
		System.out.println(e);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
