package in.nit.controller;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/emp")
public class EmployeeRestController {
@GET	
public String showA() {
	return "GET Employee ShowA";
}
@GET
@Path("/b")
public String showB() {
	return "GET Employee Showb";
}
@POST
public String showC() {
	return "POST Employee showC";
}
@POST
@Path("/d")
public String showD() {
	return "POST Employee showD";
}
}
