package in.nit.test;

import com.google.gson.Gson;

import in.nit.model.Employee;

public class ObjectToJsontest {

	public static void main(String[] args) {
		try {
//1.create model class object
		Employee e=new Employee();
		e.setEId(101);
		e.setEName("Sankar");
		e.setESal(33.00D);
		//2.Create Gson class Object
		Gson g=new Gson();
		//3.Call toJson() method 
		String json=g.toJson(e);
		//4.print Gson String
		System.out.println(json);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
