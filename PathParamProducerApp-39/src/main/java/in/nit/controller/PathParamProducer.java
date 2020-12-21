package in.nit.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/emp")
public class PathParamProducer {

	@GET
	@Path("/data/{name}")
	public String show(
			@PathParam("name")String name
			) {
		
		return "Name is : "+name;
	}
}
