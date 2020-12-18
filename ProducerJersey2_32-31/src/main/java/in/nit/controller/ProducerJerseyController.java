package in.nit.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/prod")
public class ProducerJerseyController {

	@Path("/s")
	@GET
	public String messageOne() {
		
		return "Message Displayed...";
	}
	
}
