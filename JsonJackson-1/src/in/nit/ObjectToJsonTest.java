package in.nit;

import org.codehaus.jackson.map.ObjectMapper;

import in.nit.model.Employee;

//ctrl+shift+o for imports
public class ObjectToJsonTest {
	//main >ctrl+space>enter
	public static void main(String[] args) {
		//try >ctrl space>enter
		try {
			//a.Create model class Object
			Employee emp=new Employee();
			emp.setEid(100);
			emp.setEname("Sankar");
			emp.setEsal(33.00);
			
			//b.create ObjectMapper Object 
			ObjectMapper om=new ObjectMapper();
			//c. call Write method()
			String json=om.writeValueAsString(emp);
			//d. Print JSON
			System.out.println(json);
			//Run Code :: ctrl+F11
			
		} catch (Exception e) {
		
		}
	}

}
