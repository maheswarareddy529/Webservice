package in.nit.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import in.nit.model.Student;
import in.nit.service.IStudentService;

@Path("/students")
public class StudentRestController {
@Inject//gets impl class Object at runtime	
private IStudentService service;//HAS-A

//Save Student
@POST
@Consumes("application/json")
public Response saveStudent(Student student) {
	Response resp=null;
	try {
		//Call Service Layer(SL)  to Save
		Integer count=service.saveStudent(student);
		if(count>0) {
			resp=Response.status(Status.CREATED)//201-Success
					.entity("Student Saved!")
					.build();
		}
		else {
			resp=Response.status(Status.BAD_REQUEST)//400-Wrong Input
					.entity("Student Not Saved!")
					.build();
		}
	}
	catch(Exception e) {
		resp=Response.status(Status.INTERNAL_SERVER_ERROR)//500-Exception
				.entity("Student Not Saved!...Error")
				.build();
		e.printStackTrace();
	}
	return resp;
}
}
