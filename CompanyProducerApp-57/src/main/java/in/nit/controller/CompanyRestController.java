package in.nit.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import in.nit.model.Admin;
import in.nit.model.Developer;
import in.nit.model.ErrorType;
@Path("/cmp")
public class CompanyRestController {
	//...rest/cpm/info?id=202&.........
	@Path("/info")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	//@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
public Response showServiceInfo(
		@QueryParam("type")String type,
		@QueryParam("id")int id,
		@QueryParam("name")String name
		) {
		Response resp=null;
		try {
			if(id<=0 || name==null || "".equals(name.trim())) {
				resp=Response.status(400)
						.entity(new ErrorType(-1,"Invalid Id, name are given"))
						.build();
			}
			else if(type.equalsIgnoreCase("ADMIN")) {
				resp=Response.status(200)
						.entity(new Admin(id,name,type))
						.build();
			}
			else if(type.equalsIgnoreCase("DEV")) {
				resp=Response.status(Status.OK)
						.entity(new Developer(id,name,type))
								.build();
			}
			else {//Type as no matched value.
				resp=Response.status(Status.BAD_REQUEST)
						.entity(new ErrorType(id,type+"NOT FOUND, with name"+name))
						.build();
			}
		} catch (Exception e) {//type as null
		resp=Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(new ErrorType(-1,"Invalid Type Specified....."))
				.build();
		}
		
	return resp;
}
}
