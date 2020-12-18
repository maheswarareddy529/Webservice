package in.nit.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/pay")
public class PaymentRestController {
	@GET
	public String showMsg() {
		return "payment Done";
	}
}
