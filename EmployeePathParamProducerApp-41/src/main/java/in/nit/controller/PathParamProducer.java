package in.nit.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/emp")
public class PathParamProducer {

	@GET
	@Path("/data/code")
	public String showA() {
		
		return " From All Static Data.... ";
	}
	@GET
	@Path("/data/{code}")
	public String showB(
			@PathParam("code")String code
			) {
		
		return " From Dynamic code is :"+code;
	}
}
