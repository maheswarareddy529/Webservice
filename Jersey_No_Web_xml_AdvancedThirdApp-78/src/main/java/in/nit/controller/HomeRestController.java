package in.nit.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/home")
public class HomeRestController {
	@GET
   public String show(){
	   System.out.println("From rest Controller");
	   return "Welcome To Home!";
   }
}
