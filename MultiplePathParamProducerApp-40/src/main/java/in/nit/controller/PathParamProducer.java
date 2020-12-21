package in.nit.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/emp")
public class PathParamProducer {

	@GET
	@Path("/data/{eid}/{ename}/{esal}")
	public String fetchAll(
			@PathParam("eid")int eid,
			@PathParam("ename")String ename,
			@PathParam("esal")double esal
			) {
		
		return " Employee id:  "+eid+"Name is:"+ename+" Salary is : "+esal;
	}
}
