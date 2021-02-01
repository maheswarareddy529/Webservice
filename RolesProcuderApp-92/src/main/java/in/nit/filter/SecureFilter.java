package in.nit.filter;
import java.lang.reflect.Method;
import java.util.List;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
public class SecureFilter implements  ContainerRequestFilter {
	@Context
	private ResourceInfo info;
     @Context//Read Container Object      
	private HttpHeaders headers;
     @Override
    public void filter(ContainerRequestContext req) throws java.io.IOException { 
       Method method=info.getResourceMethod();
       if(!method.isAnnotationPresent(PermitAll.class)) {
    	   if(method.isAnnotationPresent(DenyAll.class)) {
    		   req.abortWith(
    		   Response
    		   .status(Status.FORBIDDEN)
    		   .entity("NO ACCESS")
    		   .build());
    	   }
       }
    	 
        //Reader Auth Header
        List<String> authList=headers.getRequestHeader("Authorization");
        if(authList==null || authList.isEmpty()) {
        	req.abortWith(
        			Response
        			.status(Status.BAD_REQUEST)
        			.entity("No Security Details Found")
        			.build()
        			);
        	return;
        }
        //else it will Continue to restController
    }
}
