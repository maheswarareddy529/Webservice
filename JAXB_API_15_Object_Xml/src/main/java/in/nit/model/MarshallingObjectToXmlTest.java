package in.nit.model;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.nt.test.Employee;

public class MarshallingObjectToXmlTest {
//Object->XML
	public static void main(String[] args) {
		try {
			//Output XML File Located with Name
			File f=new File("g.xml");
			//1.Create Model class Object
			Employee e =new Employee();
			e.setEmpId(101);
			e.setEmpName("Sankar");
			e.setEmpSal(34.88D);
			e.setEmpDept("Dev1");
			//2.Create JAXBContent Object
			//It supports converting only Employee class:Object<->XML
			JAXBContext context=JAXBContext.newInstance(Employee.class);
			//3.create Marshaller Object using context Object
			Marshaller marshaller=context.createMarshaller();
			//4.Call mthod marshal
			marshaller.marshal(e, f);
			//print any message
			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
