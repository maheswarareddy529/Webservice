package in.nit.controller; 

import javax.ws.rs.GET;
import javax.ws.rs.Path;

//ctrl+shift+o for imports
@Path("/emp")
public class EmployeeRestController {
    @GET
	public String showMsg() {
		return "Welcome to RestWebSevices";
	}
}
