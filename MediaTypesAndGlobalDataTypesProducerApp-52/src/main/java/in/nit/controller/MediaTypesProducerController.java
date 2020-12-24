package in.nit.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import in.nit.model.Student;

@Path("/std")
public class MediaTypesProducerController {
	
	/* here, we are working on return type only */
	@Path("/info")
	@GET
	@Produces("application/json")
	// or 
	//@Produces(MediaType.APPLICATION_JSON)
	
	//@Produces("application/xml")
	//or
	//@Produces(MediaType.APPLICATION_XML)
public Student showData() {
	Student s=new Student();
	s.setSId(202);
	s.setSName("Sankar");
	s.setSfees(34.56);
	return s;
}
}
