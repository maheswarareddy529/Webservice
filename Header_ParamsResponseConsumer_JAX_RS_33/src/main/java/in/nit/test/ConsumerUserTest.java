package in.nit.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class ConsumerUserTest {

	public static void main(String[] args) {
		String url="http://localhost:3031/Header_ParamsResponseProducer_JAX_RS_33";
		String path="rest/user/validate";
		try {
			
			Client c=ClientBuilder.newClient();
			WebTarget wt=c.target(url).path(path);
			
			Invocation.Builder builder=wt.request();
			/*
			 * builder=builder.header("user","developer");
			 * builder=builder.header("pwd","sankar"); 
			 * Response resp=builder.get();
			 */
			Response resp=builder
					.header("user","developer")
					.header("pwd","sankar")
					.get();
			
			System.out.println(resp.getStatus());//200
			System.out.println(resp.getStatusInfo());//ok
			System.out.println(resp.readEntity(String.class));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
