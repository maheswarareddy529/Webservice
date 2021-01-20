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
	@Inject
	private IStudentService service; //HAS-A

	//1. save data into DB
	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public Response saveStudent(Student student) {
		Response resp=null;

		try {
			//call service layer to save
			Integer count=service.saveStudent(student);
			if(count>0) {
				resp = Response.status(Status.CREATED) //201 -success
						.entity("Student Saved!")
						.build();
			}else {
				resp = Response.status(Status.BAD_REQUEST) //400-wrong input
						.entity("Student not saved!")
						.build();
			}
		} catch (Exception e) {
			resp = Response.status(Status.INTERNAL_SERVER_ERROR)//500-exception
					.entity("Student not saved!")
					.build();
			e.printStackTrace();
		}

		return resp;
	}

	//2. Fetching data from Database
	@GET
	@Produces("application/json")
	public Response getAllStudents() {
		Response resp=null;
		try {

			List<Student> list=service.getAllStudents();
			resp =  Response
					.status(Status.OK)
					.entity(list)
					.build();

		} catch (Exception e) {
			resp = Response.status(Status.INTERNAL_SERVER_ERROR)//500-exception
					.entity("Unable to Fetch Data!!")
					.build();

			e.printStackTrace();
		}
		return resp;
	}


	//3. Delete based on ID
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response deleteOneStudent(
			@PathParam("id")Integer id) 
	{
		Response resp=null;
		try {
			boolean status=service.removeOneStudent(id);
			if(status) {
				resp = Response
						.status(Status.OK)
						.entity("Student '"+id+"' Deleted")
						.build();
			}else {
				resp = Response
						.status(Status.BAD_REQUEST)
						.entity("Student '"+id+"' Not exist")
						.build();
			}

		} catch (Exception e) {
			resp = Response.status(Status.INTERNAL_SERVER_ERROR)//500-exception
					.entity("Unable to Delete Data!!")
					.build();
			e.printStackTrace();
		}

		return resp;
	}

	//4. fetch one student by Id
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response getOneStudent(
			@PathParam("id")Integer id
			) 
	{
		Response resp=null;
		try {

			Student s=service.getOneStudent(id);
			if(s!=null) {
				resp = Response.status(Status.OK)
						.entity(s)
						.build();
			}else {
				resp = Response.status(Status.NO_CONTENT)
						.build();
			}

		} catch (Exception e) {
			resp = Response.status(Status.INTERNAL_SERVER_ERROR)//500-exception
					.entity("Unable to Fech Student Data!!")
					.build();
			e.printStackTrace();
		}
		return resp;
	}

	
	//5. Update one Student based on
	@PUT
	@Consumes("application/json")
	//@Produces(MediaType.TEXT_PLAIN)
	@Produces("text/plain")
	public Response updateOneStudent(
			Student student) 
	{
		Response resp=null;
		try {
			boolean status=service.updateStudent(student);
			if(status) {
				resp = Response
						//.status(Status.RESET_CONTENT) //205
						.status(Status.OK) //200
						.entity("Student Updated!")
						.build();
			}else {
				resp = Response
						.status(Status.BAD_REQUEST) //400
						//.status(Status.NOT_FOUND) //404
						.entity("Student '"+student.getStdId()+"' Not Found!")
						.build();
			}
		} catch (Exception e) {
			resp = Response.status(Status.INTERNAL_SERVER_ERROR)//500-exception
					.entity("Unable to Update Student Data!!")
					.build();
			e.printStackTrace();
		}
		return resp;
	}

}





