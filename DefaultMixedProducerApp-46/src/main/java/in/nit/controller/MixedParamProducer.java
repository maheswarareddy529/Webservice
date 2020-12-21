package in.nit.controller;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
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
			@DefaultValue("101") @QueryParam("id")int id,
			@DefaultValue("Sankar") @HeaderParam("name")String name,
			@DefaultValue("23.444") @FormParam("fee")double fee
			) {
		
		return "Data Given Is => :  "+id+"-"+name+"-"+fee;
	}
}
