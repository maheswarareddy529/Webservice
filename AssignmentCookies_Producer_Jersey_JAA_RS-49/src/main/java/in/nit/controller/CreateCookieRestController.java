package in.nit.controller;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/cookie")
public class CreateCookieRestController {

	@GET
	@Path("/create")
	public Response createCookie() {
		
		//create one new Cookie Object
		NewCookie cookie=new NewCookie("userType","ADMIN");
		NewCookie cookie1=new NewCookie("format","RED");
		NewCookie cookie2=new NewCookie("accessMode","Enable",null,null,null,20,false);//20 seconds after removed
		//Cookie Added to Response
		Response resp=Response
				.status(Status.OK)
				.entity("Cookies are Created!")
				.cookie(cookie,cookie1,cookie2)
				.build();
		//Response Sent to Client Machine
		
		return resp;
	}
	@GET
	@Path("/read")
	public String readCookies(
			@CookieParam("userType")String user,
			@CookieParam("format")String color,
			@CookieParam("accessMode")String mode
			) {
		StringBuffer sb=new StringBuffer();
		
		String message=sb
				.append("Cookies Data=>  ")
				.append("  User Type Is : ").append(user)
				.append(" , Format Is:  ").append(color)
				.append(" AccessMode Is : ").append(mode)
				.toString();
		
		return message;
	}
}
