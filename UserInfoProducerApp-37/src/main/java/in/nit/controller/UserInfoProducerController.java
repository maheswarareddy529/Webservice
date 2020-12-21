package in.nit.controller;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/user")
public class UserInfoProducerController {

	@Path("/info")
	@POST
	public String readUserInfo(
			@FormParam("unqCode")String code,
			@FormParam("secureId")String id,
			@FormParam("accessToken")String token,
			@FormParam("permitRole")String role
			) {
		StringBuffer sb=new StringBuffer();
		String message=sb
				.append(" Code Is : ").append(code)
				.append(" , Secure ID IS : ").append(id)
				.append(" , Toke Is : ").append(token)
				.append(", Role : ").append(role)
				.toString();
		return message;
	}
}
