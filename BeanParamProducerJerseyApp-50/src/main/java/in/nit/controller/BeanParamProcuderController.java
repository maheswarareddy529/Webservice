package in.nit.controller;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import in.nit.model.Employee;

@Path("/emp")
public class BeanParamProcuderController {
      //.../rest/emp/data?eid=202&ename=Sankar&esal=23.44
	
	@GET
	@Path("/data")
	public String readInputs(
			@BeanParam Employee employee
			) {
		
		return "Data is =>  "+employee;
	}
}
