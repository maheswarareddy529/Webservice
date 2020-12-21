package in.nit.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class ConsumerTest {

	public static void main(String[] args) {
	String url="http://localhost:3031/PathParamProducerApp2Param-42";
	String path="/rest/emp/data/234we/yy/Sankar";
	try {
		Client c=ClientBuilder.newClient();
		WebTarget wt=c.target(url).path(path);
		
		Invocation.Builder builder=wt.request();
		Response resp=builder.get();
		
		System.out.println(resp.getStatus());
		System.out.println(resp.getStatusInfo());
		System.out.println(resp.readEntity(String.class));
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

}
