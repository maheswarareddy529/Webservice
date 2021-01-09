package in.nit.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/msg")
public class MessageRestController {
   @GET
	public String show() {
		
		return "Hello From Advanced Config!";
	}
}
