package in.nit.model; 
 
import java.io.File;

import javax.xml.bind.JAXBContext;

import javax.xml.bind.Unmarshaller;

import com.nt.test.Employee;

public class UnMarshallingObjectToXmlNewTest {
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
			System.out.println(ob);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
