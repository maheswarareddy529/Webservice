package in.nit.filter;

import java.io.IOException;
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

public class SecureRoleFilter 
implements ContainerRequestFilter
{
	@Context
	private ResourceInfo info;

	@Context
	private HttpHeaders headers;

	@Override
	public void filter(ContainerRequestContext req)
			throws IOException {
		Method m=info.getResourceMethod();
		/**************PERMIT ALL/DENY ALL*****************/
		if(m.isAnnotationPresent(PermitAll.class)) {
			//no chcking required
			return;
		}
		if(m.isAnnotationPresent(DenyAll.class)) {
			req.abortWith(
					Response
					.status(Status.FORBIDDEN)
					.entity("NO ACCESS")
					.build()
					);
			return ;
		}


		/**************AUTHORIZATION HEADER EMPTY CHECK*****************/
		List<String> authList=headers.getRequestHeader("Authorization");
		if(authList==null || authList.isEmpty()) {
			req.abortWith(
					Response
					.status(Status.BAD_REQUEST)
					.entity("NO USER DETAILS FOUND")
					.build()
					);
			return;
		}
		/**************AUTHORIZATION => UN/PWD*****************/
		//TODO  Read user/pwd 
		String un=null,pwd=null;
		try {
			String auth=authList.get(0);
			//Remove Basic<Space>
			auth=auth.replaceAll("Basic ", "");
			//Decode auth
			byte[] arr=Base64.decodeBase64(auth.getBytes());
			//convert to String
			auth=new String(arr);
			//Tokenize data
			StringTokenizer str=new StringTokenizer(auth,":");
			un=str.nextToken();
			pwd=str.nextToken();
		} catch (Exception e) {
			e.printStackTrace();
			req.abortWith(
					Response
					.status(Status.INTERNAL_SERVER_ERROR)
					.entity("UNBALE TO GET AUTHORIZATION DATA")
					.build()
					);
			return;
		}
		/**************VERIFY UN/PWD with DB*****************/
		if(!UserValidator.validateUser(un, pwd)) {
			req.abortWith(
					Response
					.status(Status.UNAUTHORIZED)
					.entity("INVALID UN/PWD[User/Pwd not Exist]")
					.build()
					);
			return;
		}

		/**************Read User Role and VERIFY HERE*****************/
		//read current request method level roles
		String[] rolesArr=m.getAnnotation(RolesAllowed.class).value();
		//convert into List
		List<String> methodRoles=Arrays.asList(rolesArr);
		System.out.println(methodRoles);

		//Get user Roles from Db based on UN
		String userRole=UserValidator.getRoleByUser(un);
		//check user role is allowed for request method
		if(!methodRoles.contains(userRole)) {
			req.abortWith(
					Response
					.status(Status.FORBIDDEN)
					.entity("INVAILD ROLE TO ACCESS THIS SERVICE")
					.build()
					);
			return ;
		}
	}
}







