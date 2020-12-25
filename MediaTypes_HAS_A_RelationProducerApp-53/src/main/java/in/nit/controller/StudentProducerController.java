package in.nit.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import in.nit.model.Address;
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
		
		Address addr=new Address();
		addr.setHNo("2-62");
		addr.setLoc("HYD");
		addr.setCity("Ammerpet");
		
	Student s=new Student();
	s.setSId(202);
	s.setSName("Sankar");
	s.setAddr(addr);//Link between Objects.
	return s;
}
}
