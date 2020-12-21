package in.nit.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/emp")
public class PathParamProducer {
	
	@GET
	@Path("/data/{data}/yy/{name}")
	public String showB(
			@PathParam("data")String data,
			@PathParam("name")String name
			) {
		
		return " Data  is:"+data+" Name is :  "+name;
	}
}
