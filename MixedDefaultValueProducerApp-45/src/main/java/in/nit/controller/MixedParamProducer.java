package in.nit.controller;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/info")
public class MixedParamProducer {
	@POST
	//@Consumes("application/x-www-form-urlencoded") optional
	@Consumes("application/x-www-form-urlencoded")
	public String readData(
			@QueryParam("id")int id,
			@HeaderParam("name")String name,
			@FormParam("fee")double fee
			) {
		
		return "Data Given Is => :  "+id+"-"+name+"-"+fee;
	}
}
