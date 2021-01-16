package in.nit.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/home")
public class HomeRestController {
	@GET
	public String show() {
		
		return "WELCOME TO APP!!";
	}

}
