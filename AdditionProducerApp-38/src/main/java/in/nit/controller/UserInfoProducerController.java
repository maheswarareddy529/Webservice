package in.nit.controller;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/math")
public class UserInfoProducerController {

	@Path("/add")
	@POST
	public String readUserInfo(
			@FormParam("a")Integer a,
			@FormParam("b")Integer b,
			@FormParam("c")Integer c
			) {
		Integer total=a+b+c;
		StringBuffer sb=new StringBuffer();
		String message=sb
				.append(" A : ").append(a)
				.append(" , B : ").append(b)
				.append(" , C : ").append(c)
				.append(", Total =   ").append(total)
				.toString();
		return message;
	}
}
