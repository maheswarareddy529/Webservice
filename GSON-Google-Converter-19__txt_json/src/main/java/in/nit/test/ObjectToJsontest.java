package in.nit.test;
import java.io.File;
import java.util.Scanner;
import com.google.gson.Gson;
import in.nit.model.Employee;
public class ObjectToJsontest {

	public static void main(String[] args) {
		try {
			//holding file
			File f=new File("g.txt");
			
			//reading file
			Scanner sc=new Scanner(f);
			
			//1. Model class Object
			Employee e=new Employee();
			
			//loop
			for(int i=0;i<2;i++) {
				int id=sc.nextInt();
				e.setEId(id);
				String name=sc.next();
				e.setEName(name);
				String eCountry=sc.next();
				e.setECountry(eCountry);
				String eCode=sc.next();
				e.setECode(eCode);
				String date=sc.next();
				e.setEDate(date);
				
				//2.Create Gson class Object
				Gson g=new Gson();
				
				//3.Call toJson() method 
				String json=g.toJson(e);
				
				//4.print Gson String
				System.out.println(json);
				//next line
				sc.hasNextLine();
			}
			sc.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
