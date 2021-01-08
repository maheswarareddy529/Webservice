/*
 * package in.nit.controller;
 * 
 * import javax.ws.rs.GET; import javax.ws.rs.Path; import
 * javax.ws.rs.QueryParam; import javax.ws.rs.core.Response;
 * 
 * @Path("/resp") public class ProducerQeuryParameter {
 * 
 * @Path("/r")
 * 
 * @GET public Response doOperation(
 * 
 * @QueryParam("id")Integer id,
 * 
 * @QueryParam("name")Integer name ) { Object output=id+" , "+name;
 * 
 * return Response.status(200).entity(output).build(); } }
 */
//-----------------------------------------------------------------------------------------------------------------------------

/*
 * package in.nit.controller; import javax.ws.rs.GET; import
 * javax.ws.rs.MatrixParam; import javax.ws.rs.Path;
 * 
 * @Path("/resp") public class ProducerQeuryParameter {
 * 
 * @Path("/r")
 * 
 * @GET public String doOperation(
 * 
 * @MatrixParam("id")Integer id,
 * 
 * @MatrixParam("name")Integer name ) {
 * 
 * return "id is :"+id+" name is : "+name; } }
 */

//----------------------------------------------------------------------------------------------------------------


/*
 * package in.nit.controller; import javax.ws.rs.GET; import
 * javax.ws.rs.HeaderParam; import javax.ws.rs.Path; import
 * javax.ws.rs.core.Response; import javax.ws.rs.core.Response.Status;
 * 
 * @Path("/resp") public class ProducerHeaderParamController {
 * 
 * @Path("/r")
 * 
 * @GET public Response validateUser(
 * 
 * @HeaderParam("id")String id,
 * 
 * @HeaderParam("name")String name ) { Object output=id+" , "+name;
 * 
 * return Response.status(200).entity(output).build(); } }
 */
//-------------------------------------------------------------------------------------------------------------------

/*
 * package in.nit.controller; import javax.ws.rs.FormParam; import
 * javax.ws.rs.POST; import javax.ws.rs.Path;
 * 
 * @Path("/resp") public class ProducerHeaderParamController {
 * 
 * @Path("/r")
 * 
 * @POST public String validateUser(
 * 
 * @FormParam("id")String id,
 * 
 * @FormParam("name")String name ) { return "id : "+id+" name: "+name; } }
 */
//---------------------------------------------------------------------------------------------------------------------------------------

/*
 * package in.nit.controller; import javax.ws.rs.FormParam; import
 * javax.ws.rs.POST; import javax.ws.rs.Path;
 * 
 * @Path("/resp") public class ProducerHeaderParamController {
 * 
 * @Path("/r")
 * 
 * @POST public String validateUser(
 * 
 * @FormParam("id")String id,
 * 
 * @FormParam("name")String name ) { return "id : "+id+" name: "+name; } }
 */
//------------------------------------------------------------------------

/*
 * package in.nit.controller; import javax.ws.rs.DefaultValue; import
 * javax.ws.rs.GET; import javax.ws.rs.Path; import javax.ws.rs.PathParam;
 * 
 * @Path("/resp") public class ProducerHeaderParamController {
 * 
 * @Path("/r")
 * 
 * @GET public String validateUser(
 * 
 * @DefaultValue("12")
 * 
 * @PathParam("id")int id,
 * 
 * @DefaultValue("Sankar")
 * 
 * @PathParam("name")String name ) { return "id : "+id+" name: "+name; } }
 */
package in.nit.controller;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import in.nit.model.Employee;

@Path("/resp")
public class BeanParamProcuderController {
      //.../rest/emp/data?eid=202&ename=Sankar&esal=23.44
	
	@GET
	@Path("/r")
	public String readInputs(
			@BeanParam Employee employee
			) {
		
		return "Data is =>  "+employee;
	}
}