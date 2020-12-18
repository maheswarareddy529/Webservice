package in.nit.controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
@Path("/gst")
public class ProducerGSTParameters {
	//.../gst?bcost=5.6&gper=2
	
	String message=null;
	@GET
	public String readInputs(@QueryParam("bcost")double amt,
			                                    @QueryParam("gper")int per
			                                  ) {
		
		if(amt>0.0&&per>0) {
			double gstAmount=amt*per/100.0;
			double finalAmt=amt+gstAmount;
			
			message="Final Cost is:  "+finalAmt;
			
		}
		else {
			message=" Please Enter Base Cost(bcost) and GSTPercentage(gper)";
		}
		
		return message;
	}

}
