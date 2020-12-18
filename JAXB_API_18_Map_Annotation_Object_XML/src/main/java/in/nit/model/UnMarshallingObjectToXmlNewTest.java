package in.nit.model; 
import java.io.File;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import com.nt.test.Company;
public class UnMarshallingObjectToXmlNewTest {
//Object->XML
	public static void main(String[] args) {
		try {
			//Create Model class Object
			Company c=new Company();
			c.setCId(101);
			//jdk9
			c.setProjects(Map.of("p1","v1","p2","v2","p3","v3"));
			
			//Create JAXBContext object for Model class
			JAXBContext context=JAXBContext.newInstance(Company.class);
			//3.create marshaller Object using context Object
			Marshaller m=context.createMarshaller();
			//4.Call mthod marshal
			m.marshal(c, new File("g.xml"));
			//print any message
			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
