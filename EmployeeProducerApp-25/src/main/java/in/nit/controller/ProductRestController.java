package in.nit.controller;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

@Path("/prod")
public class ProductRestController {
	
	@GET	
	public String showA() {
		return "GET Employee ShowA";
	}
	@POST
	public String showB() {
		return "POST Employee Showb";
	}
	@PUT
	public String showC() {
		return "POST Employee showC";
	}
	@DELETE
	public String showD() {
		return "DELETE Employee showD";
	}

}
