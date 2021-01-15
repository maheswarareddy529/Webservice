package in.nit.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

public class MyRequestFilter implements ContainerRequestFilter {
	@Context
	private HttpServletRequest req;//HAS-A
	@Context
	private HttpHeaders headers;//HAS-A

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
	System.out.println("----------START #FROM FILTER WITH CONTAINER OBJECTS-----------");
	System.out.println(req.getRequestURL());	
	System.out.println(req.getRequestURI());
    System.out.println(req.getContextPath());
    System.out.println(req.getMethod());
    System.out.println(req.getLocalAddr());
    
    System.out.println(headers.getRequestHeader("clientId"));
    System.out.println(headers.getRequestHeader("secret"));
    System.out.println("--------END#FROM FILTER WITH CONTAINER OBJECTS---------");
	}

}
