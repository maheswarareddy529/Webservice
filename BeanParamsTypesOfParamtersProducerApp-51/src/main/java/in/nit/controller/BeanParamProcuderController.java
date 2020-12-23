package in.nit.controller;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import in.nit.model.Employee;

@Path("/emp")
public class BeanParamProcuderController {
	
	@POST
	@Path("/data")
	//@Consumes(MediaType.APPLICATION_FORM_URLENCODED)//it is optional
	public String readInputs(
			@BeanParam Employee employee
			) {
		
		return "Data is =>  "+employee;
	}
}
