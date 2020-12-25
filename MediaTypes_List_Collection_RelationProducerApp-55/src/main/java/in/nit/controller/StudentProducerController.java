package in.nit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import in.nit.model.Address;
import in.nit.model.Country;
import in.nit.model.Course;
import in.nit.model.Student;

@Path("/std")
public class StudentProducerController {
	@Path("/link")
	@GET
	//@Produces("application/json")
	//@Produces("application/xml")
	//Request ( header Param: Accept  = application/xml )
	@Produces({"application/json","application/xml"})
public Student showData() {
		Country ctn=new Country();
		ctn.setCode("3vrgr");
		ctn.setCapitial("Delhi");
		
		Address addr=new Address();
		addr.setHNo("2-62");
		addr.setLoc("HYD");
		addr.setCity("Ammerpet");
		addr.setCtn(ctn);//HAS-A link between Objects.
		
	Student s=new Student();
	s.setSId(202);
	s.setSName("Sankar");
	s.setAddr(addr);//Link between Objects.
	
	Course c1=new Course("webservices",234.2,6);
	Course c2=new Course("hibernate",231.2,4);
	Course c3=new Course("Spring",201.2,8);
//JDK7  Collection-Type Inference ( empty <> operator )
	
	List<Course> list=new ArrayList<>();
	list.add(c1);
	list.add(c2);
	list.add(c3);
	s.setCos(list);
	return s;
}
	@Path("/link1")
	@GET
	//@Produces("application/json")
	//@Produces("application/xml")
	//Request ( header Param: Accept  = application/xml )
	@Produces({"application/json","application/xml"})
public Student showData1() {
		/*Country ctn=new Country();
		ctn.setCode("3vrgr");
		ctn.setCapitial("Delhi");
		
		Address addr=new Address();
		addr.setHNo("2-62");
		addr.setLoc("HYD");
		addr.setCity("Ammerpet");
		addr.setCtn(ctn);//HAS-A link between Objects.*/
		
	Student s=new Student();
	s.setSId(202);
	s.setSName("Sankar");
	//s.setAddr(addr);//Link between Objects.
	
	/*Course c1=new Course("webservices",234.2,6);
	Course c2=new Course("hibernate",231.2,4);
	Course c3=new Course("Spring",201.2,8);
//JDK7  Collection-Type Inference ( empty <> operator )
	
	List<Course> list=new ArrayList<>();
	list.add(c1);
	list.add(c2);
	list.add(c3);
	s.setCos(list);*/
	return s;
}
}
