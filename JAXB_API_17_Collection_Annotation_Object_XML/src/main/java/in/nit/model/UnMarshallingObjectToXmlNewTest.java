package in.nit.model; 
 
import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.nt.test.Student;


public class UnMarshallingObjectToXmlNewTest {
//Object->XML
	public static void main(String[] args) {
		try {
			//Create Model class Object
			Student s=new Student();
			s.setStdId(100);
			s.setStdCode("ABC");
			//jdk9
			s.setSubject(List.of("ENG","MAT","SCI"));
			
			//or
			//Generic type safe<>
			//List<String> list=new ArrayList<>();
			//list.add("ENG"); list.add("MAT"); list.add("SCI");
			//s.setSubject(list);
			
			//or
		//	List<String> list=List.of("ENG","MAT","SCI");
			//s.setSubject(list);
			
			//Create JAXBContext object for Model class
			JAXBContext context=JAXBContext.newInstance(Student.class);
			//3.create marshaller Object using context Object
			Marshaller m=context.createMarshaller();
			//4.Call mthod marshal
			m.marshal(s, new File("g.xml"));
			//print any message
			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
