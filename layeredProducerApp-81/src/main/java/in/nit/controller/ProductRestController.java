package in.nit.controller;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import in.nit.service.IProductService;

@Path("/products")
public class ProductRestController {
@Inject//gets impl class Object at runtime	
private IProductService service;//HAS-A

@GET
public String findMsg() {
	
	return " FROM RESTCONTROLLER=> "+service.showService();
}
}
