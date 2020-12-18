package in.nit.controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
@Path("/emp")
public class ProductRestControllerParameters {
	//.../emp?eid=9&ename=A&esal=3.4
	
	@GET
	public String readInputs(@QueryParam("eid")int eid,
			                                    @QueryParam("ename")String ename,
			                                    @QueryParam("esal")double esal
			                                  ) {
		
		return " Input Data Is:  ID +"+eid+", NAME= "+ename+" , ESAL= "+esal;
	}

}
