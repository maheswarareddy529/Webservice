package in.nit.controller; 
import javax.ws.rs.GET;
import javax.ws.rs.Path;

//ctrl+shift+o for imports
@Path("/producer")
public class ProducerRestController {
    @GET
	public String showMsg() {
		return "From Producer Service..";
	}
}
