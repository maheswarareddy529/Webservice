package in.nit.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/user")
public class UserRestController {

	@GET
	public String showMsg() {
		
		return "Welcome To Consumer";
	}
}
