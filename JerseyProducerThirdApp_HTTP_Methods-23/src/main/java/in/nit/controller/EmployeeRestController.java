package in.nit.controller; 

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

//ctrl+shift+o for imports
@Path("/emp")
public class EmployeeRestController {
    @GET
	public String showMsg() {
		return "Fetched Data...";
	}
    @POST
   	public String showMsg1() {
   		return "Saved Data...";
   	}
    @PUT
   	public String showMsg2() {
   		return "Modified Data...";
   	}
    @DELETE
   	public String showMsg3() {
   		return "Removed Saved Data...";
   	}
}
