package in.nit.filter;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import in.nit.validate.ClientValidator;

public class SecurityFilter implements ContainerRequestFilter {
	@Context
	private  HttpHeaders headers;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		//Reading Two Header Params
		List<String> cid=headers.getRequestHeader("clientId");
		List<String> cser=headers.getRequestHeader("secret");
		
		//Check for Null or Empty
		if(cid==null || cid.isEmpty() || cser==null || cser.isEmpty()) {
			requestContext.abortWith(
					Response.status(Status.BAD_REQUEST)
					.entity("Provide clientId/secret")
					.build()
					);
			return;
		}
		else {
			String clientId=cid.get(0);
			String secret=cser.get(0);
			//Check for Actual Data
			//if(!("nit".equals(clientId)&&"raghu".equals(secret))) {
			if(!ClientValidator.exist(clientId, secret)) {
				requestContext.abortWith(
						Response.status(Status.UNAUTHORIZED)
						.entity("Invalid clientId/secret!!")
						.build()
						);
				
			}
			return;
		}

	}

}
 