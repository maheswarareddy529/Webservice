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
		
		return "Welcome To All Consumer!";
	}
	
	@GET
	@Path("/none")
	@DenyAll
	public String noMsg() {
		
		return "you can not see this!!";
	}
	
	@GET
	@Path("/info")
	@RolesAllowed({"EMPLOYEE","CUSTOMER"})
	public String welcomeToService() {
		
		return "welcome to EMPLOYEE/CUSTOMER!!";
	}
	@GET
	@Path("/form")
	@RolesAllowed({"EMPLOYEE","ADMIN"})
	public String welcomeToForm() {
		return "welcome to EMPLOYEE/ADMIN!!!";
	}
}
