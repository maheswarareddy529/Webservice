package in.nit.filter;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.tomcat.util.codec.binary.Base64;

import in.nit.validator.UserValidator;
public class SecureRoleFilter implements  ContainerRequestFilter {
	@Context
	private ResourceInfo info;
     @Context//Read Container Object      
	private HttpHeaders headers;
     @Override
    public void filter(ContainerRequestContext req) throws java.io.IOException { 
       Method method=info.getResourceMethod();
       /*PERMIT ALL AND DENY ALL */
       if(method.isAnnotationPresent(PermitAll.class)) {
    	  //No Checking Required
    	   return;
       }
       
    	   if(method.isAnnotationPresent(DenyAll.class)) {
    		   req.abortWith(
    		   Response
    		   .status(Status.FORBIDDEN)
    		   .entity("NO ACCESS")
    		   .build());
    		   return;
    	   }
    	 
        /* AUTHORIZATION HEADER EMPTY CHECK*/
        List<String> authList=headers.getRequestHeader("Authorization");
        if(authList==null || authList.isEmpty()) {
        	req.abortWith(
        			Response
        			.status(Status.BAD_REQUEST)
        			.entity("No User Details Found")
        			.build()
        			);
        	return;
        }
       
        /* AUTHORIZATION=>UN/PWD */
        //To do Read User/pwd
        String un=null;String pwd=null;
        try {
			String auth=authList.get(0);
			
			//Remove Basic<SPACE>
			auth=auth.replaceAll("Basic ", "");
			
			//Decode Auth
			byte[] arr=Base64.decodeBase64(auth.getBytes());
			
			//Convert to String 
			auth=new String(arr);
			
			//Tokenize Data
			StringTokenizer st=new StringTokenizer(auth,":");
			
			un=st.nextToken();
			pwd=st.nextToken();
			
		} catch (Exception e) {
			e.printStackTrace();
			req.abortWith(
					Response
					.status(Status.INTERNAL_SERVER_ERROR)
					.entity("UNABLE TO GET AUTHORIZATION DATA")
					.build()
					);
			return;
		}
        /* VERIFY UN/PWD WITH DB */
        if(!UserValidator.validateUser(un, pwd)) {
        	req.abortWith(
        			Response
        			.status(Status.UNAUTHORIZED)
        			.entity("INVALID UN/PWD [User/Pwd not Exist]")
        			.build()
        			);
        	return;
        }
        /* Read User Role and Verify Here*/
        //read current request method level roles
        String[] rolesArr=method.getAnnotation(RolesAllowed.class).value();
        
        //Convert into List
        List<String> methodRoles=Arrays.asList(rolesArr);
        System.out.println(methodRoles);
        
        //Get User Roles from DB based on UN 
        String userRole=UserValidator.getRoleByUser(un);
        
        //check user role is allowed for request method 
        if(!methodRoles.contains(userRole)) {
        	req.abortWith(
        			Response
        			.status(Status.FORBIDDEN)
        			.entity("INVALID ROLE TO ACCESS THIS SERVICE!")
        			.build()
        			);
        	return;
        }
    }
}
