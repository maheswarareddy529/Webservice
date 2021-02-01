package in.nit.controller;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/user")
public class UserRestController {

	@GET
	@Path("/all")
	@PermitAll
	public String common() {
		return "welcome to All Consumers!";
	}
	
	@GET
	@Path("/none")
	@DenyAll
	public String noMsg() {
		return "You can not see this!!";
	}
	
	@GET
	@Path("/info")
	@RolesAllowed({"EMPLOYEE","CUSTOMER"})
	public String welcomToService() {
		return "welcome to EMPLOYEE/CUSTOMER!";
	}
	
	@GET
	@Path("/form")
	@RolesAllowed({"EMPLOYEE","ADMIN"})
	public String welcomToForm() {
		return "welcome to EMPLOYEE/ADMIN!";
	}
}
