package in.nit.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import in.nit.model.Student;
@Path("/std")
public class StudentRestController {
	//@GET //it is not supported Request Body
@Path("/data")
@POST
@Consumes("application/xml,application/json")
public String readInfo(Student student) {
	return " Data is Student: => "+student;
}
}
