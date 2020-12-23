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
		NewCookie cookie=new NewCookie("LANG","HINDI");
		NewCookie cookie1=new NewCookie("LOC","HYD");
		NewCookie cookie2=new NewCookie("COMPANY","dell",null,null,"SAMPLE",30,false);
		//Cookie Added to Response
		Response resp=Response
				.status(Status.OK)
				.entity("Cookies are Created!")
				.cookie(cookie,cookie1,cookie2)
				//or
				//.cookie(cookie).cookie(cookie1).cookie(cookies)2
				.build();
		//Response Sent to Client Machine
		
		return resp;
	}
	@GET
	@Path("/read")
	public String readCookies(
			@CookieParam("LANG")String lang,
			@CookieParam("LOC")String loc,
			@CookieParam("COMPANY")String company
			) {
		StringBuffer sb=new StringBuffer();
		
		String message=sb
				.append("Cookies Data=>  ")
				.append("  Language Code: ").append(lang)
				.append(" , Location ").append(loc)
				.append(" company: ").append(company)
				.toString();
		
		return message;
	}
}
