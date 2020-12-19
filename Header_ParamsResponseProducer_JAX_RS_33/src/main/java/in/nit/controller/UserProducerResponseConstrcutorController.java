package in.nit.controller;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/user")
public class UserProducerResponseConstrcutorController {
	@Path("/validate")
	@GET
	public Response validateUser(
			          @HeaderParam("user")String user,
			          @HeaderParam("pwd")String pwd
			) {
		Response resp=null;
		try {
			if(user==null || "".equals(user.trim()) || pwd==null || "".equals(user.trim())) {
				//resp=Response.status(400).entity("No Data Provided").build();
				//or
				resp=Response.status(Status.BAD_REQUEST).entity("No Data Provided").build();
			}
			else if(user.equals("developer") && pwd.equals("sankar")) {
				//resp=Response.status(200).entity("welcome To Admin!! ").build();
				//or
				//resp=Response.status(Status.OK).entity("welcome To Admin!! ").build();
				//or
				resp=Response.ok("welcome To Admin!! ").build();
			}
			else {
				//resp=Response.status(401).entity(" Invalid userName/Password ").build();
				//or
				resp=Response.status(Status.UNAUTHORIZED).entity(" Invalid userName/Password ").build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}
}
