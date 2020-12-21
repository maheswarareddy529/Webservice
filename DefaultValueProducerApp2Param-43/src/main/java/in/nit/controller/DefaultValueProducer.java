package in.nit.controller;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/info")
public class DefaultValueProducer {
	
	@GET
	public String readData(
			@DefaultValue("10") @QueryParam("id")int id,
			
			@DefaultValue(" No Name") 
			@QueryParam("name")String name,
			
			@QueryParam("fees")double fees
			) {
		
		return "Data Given is: =>  "+id+"-"+name+"-"+fees;
	}
}
