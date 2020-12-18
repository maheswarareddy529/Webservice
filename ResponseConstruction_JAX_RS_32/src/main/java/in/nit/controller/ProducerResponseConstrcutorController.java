package in.nit.controller;
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/resp")
public class ProducerResponseConstrcutorController {
	@Path("/r")
	@GET
	public Response doOperation(
			          @QueryParam("input")Integer value
			) {
		Response resp=null;
		try {
			
			if(value==null) {
				resp=Response
						.status(400)
						.header("result: ", "Not Executed")
						.entity("No Data given")
						.build();
			}
			else {
				int res=10/value;
				resp=Response
						.status(200)
						.header("result : ", "GOOD")
						.entity("result is :  "+res)
						.build();
			}
			
		} catch (Exception e) {
			
			resp=Response
					.status(500)
					.header("Rsult : ","Faild")
					.entity("Unable to Process Request!! : ")
					.build();
			e.printStackTrace();
		}
		
		return resp;
	}
}
