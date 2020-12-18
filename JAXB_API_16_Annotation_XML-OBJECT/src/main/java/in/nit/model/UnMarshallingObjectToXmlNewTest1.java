package in.nit.model;

import java.io.File;

import javax.xml.bind.JAXBContext;

import javax.xml.bind.Unmarshaller;

import com.nt.test.Employee;

public class UnMarshallingObjectToXmlNewTest1 {
//Object->XML
	public static void main(String[] args) {
		try {
			//Output XML File Located with Name
			File f=new File("g.xml");
			
			//Create JAXBContext object for Model class
			JAXBContext context=JAXBContext.newInstance(Employee.class);
			//3.createUnmarshaller Object using context Object
			Unmarshaller un=context.createUnmarshaller();
			//4.Call mthod marshal
			//unmarshal
			Object ob=un.unmarshal(f);
			//print any message
			//toString ->Dynamic polymorphism ,call to an overridden method.
			//Downcasting Resulting Data
			
			Employee emp1=new Employee();
			System.out.println(emp1.getEmpProjects());//if you call like you get null value.
			
			if(ob instanceof Employee) {//It Avoids ClassCastException
				Employee emp=(Employee) ob;
				System.out.println(emp);
				System.out.println("------------------------");
				System.out.println(emp.getEmpProjects());
				System.out.println("-------------------");
				System.out.println(emp.getEmpExp());
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
