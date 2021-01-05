package in.nit.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/emp")
public class PathParamRestController {

	@GET
	@Path("/msg/empId/empName/empSal")
	public String show() {
		
		return "Hello#1: ";
	}
	@GET
	@Path("/msg/empId/empName/{empSal}")
	public String show2(@PathParam("empSal")Double empSal) {
		
		return "Hello#2: "+empSal;
	}
	@GET
	@Path("/msg/empId/{empName}/{empSal}")
	public String show3(
			@PathParam("empName")String empName,
			@PathParam("empSal")Double empSal) {
		
		return "Hello#3: "+empName+" , "+empSal;
	}
}
