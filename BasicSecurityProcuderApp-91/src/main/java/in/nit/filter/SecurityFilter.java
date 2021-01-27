package in.nit.filter;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.codec.binary.Base64;

import in.nit.validator.UserValidator;
public class SecurityFilter implements  ContainerRequestFilter {
     @Context//Read Container Object      
	private HttpHeaders headers;
    public void filter(ContainerRequestContext req) throws java.io.IOException { 
        System.out.println("From Filter");
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
        //Reader Auth String from Index#0
        String auth=authList.get(0);
        
        //Remove Basic<SPACE>
        auth=auth.replaceAll("Basic ","");
        
        //Decode Auth String
        byte[] arr=Base64.decodeBase64(auth.getBytes());
        auth=new String(arr);
        //Tokenizer String
        StringTokenizer st=new StringTokenizer(auth, " : ");
        String un=st.nextToken();
        String pwd=st.nextToken();
        
        //Validate
       // if(!("nit".equals(un) && "raghu".equals(pwd))) {
        if(!UserValidator.isUserExist(un, pwd)) {
        	req.abortWith(
        			Response
        			.status(Status.UNAUTHORIZED)
        			.entity("INVALID UN/PWD FOUND")
        			.build()
        			);
        	return;
        }
        //else it will Continue to restController
    }
}
