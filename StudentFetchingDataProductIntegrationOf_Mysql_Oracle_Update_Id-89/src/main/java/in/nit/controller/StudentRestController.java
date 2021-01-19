package in.nit.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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
//Fetch Student
@GET
@Produces("application/json")
public Response getAllStudents(Student student) {
	Response resp=null;
	try {
		List<Student> list=service.getAllStudents();
			resp=Response
					.status(Status.OK)
					.entity(list)
					.build();
	}
	catch(Exception e) {
		resp=Response.status(Status.INTERNAL_SERVER_ERROR)//500-Exception
				.entity("Unable to Fetch Data....")
				.build();
		e.printStackTrace();
	}
	return resp;
}
@DELETE
@Path("/{id}")//Dynamic path
public Response deleteOneStudent(
		@PathParam("id")Integer id
		) {
	Response resp=null;
	try {
		boolean status=service.removeOneStudent(id);
		if(status) {
			resp=Response 
					   .status(Status.OK)
					   .entity("Student '"+id+"' Deleted")
					   .build();
		}
		else {
			resp=Response
					.status(Status.BAD_REQUEST)
					.entity("Student '"+id+"' Not Exist")
					.build();
		}
	} catch (Exception e) {
		resp=Response
				.status(Status.INTERNAL_SERVER_ERROR)//500-Exception
				.entity(" Unable to Delete Data!!")
				.build();
	   e.printStackTrace();
	}
	return resp;
}
@GET
@Path("/{id}")
@Produces("application/json")
public Response getOneStudent(
		@PathParam("id")Integer id
		) {
	Response resp=null;
	try {
		Student s=service.getOneStudent(id);
		if(s!=null) {
			resp=Response
					.status(Status.OK)
					.entity(s)
					.build();
		}
		else {
			resp=Response
					.status(Status.NO_CONTENT)
					.build();
		}
	} catch (Exception e) {
		resp=Response
				.status(Status.INTERNAL_SERVER_ERROR)//500-Exception
				.entity("Unable To fetch Student Data!!")
				.build();
		e.printStackTrace();
	}
	return resp;
}
@PUT
@Consumes("application/json")
//@Produces(MediaType.TEXT_PLAIN)
//@Produces("text/plain")
public Response updateOneStudent(
		Student s
		) {
	Response resp=null;
	try {
		boolean status=service.updateStudent(s);
		if(status) {
			resp=Response
					//.status(Status.OK)//200
					.status(Status.RESET_CONTENT)//205
					.entity("Student Updated!")
					.build();
		}
		else {
			resp=Response
					//.status(Status.BAD_REQUEST)//400
					.status(Status.NOT_FOUND)//404
					.entity("Student'"+s.getStdId()+"' Not Found!")
					.build();
		}
	} catch (Exception e) {
		resp=Response
				.status(Status.INTERNAL_SERVER_ERROR)//500-Exception
				.entity("Unable To Update Student Data!!")
				.build();
		e.printStackTrace();
	}
	return resp;
}
}
