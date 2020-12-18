package in.nit.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class ConsumerTest {
  public static void main(String[] args) {
	String uri="http://localhost:3031/JerseyProducerFirstApp-21/";
	String path="/rest/producer";
	try {
		//1. Create Client Object
		Client c=ClientBuilder.newClient();
		
		//2.Define WebTarget by adding Target(URI) and Path
		WebTarget wt=c.target(uri).path(path);
		//3.Convert into Request Object
		//(Equals to HTTP request under Construction)
		Invocation.Builder builder=wt.request();
		
		//4.Provide HTTP Method Type
		Response resp=builder.get();
		
		//5. Read and Print Response Details
		System.out.println(resp.getStatus());
		System.out.println(resp.getStatusInfo());
		System.out.println(resp.readEntity(String.class));
	} catch (Exception e) {
			e.printStackTrace();
	}
}
}
