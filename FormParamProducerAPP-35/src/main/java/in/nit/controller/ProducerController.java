package in.nit.controller;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/payment")
public class ProducerController {

	@Path("/user")
	@POST
	public String message(
			@FormParam("u")String name
			) {
		return "hello: "+name;
	}

}
