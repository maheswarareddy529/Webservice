package in.nit.controller;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import in.nit.service.IEmpService;

@Path("/emp")
public class EmpRestController {
@Inject//gets impl class Object at runtime	
private IEmpService service;//HAS-A

@GET
@Path("/show")
public String show() {
	
	return " FROM RESTCONTROLLER=> "+service.saveEmp();
}
}
