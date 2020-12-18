package in.nit.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class ConsumerTest {

	public static void main(String[] args) {
		String uri="http://localhost:3031/EmployeeProducerApp-25";
		String path="/rest/prod";
		//String path="/rest/emp";
		//String path="/rest/emp/b";
		//String path="/rest/emp/d";
	try {
		Client c=ClientBuilder.newClient();
		WebTarget wt=c.target(uri).path(path);
		
		Invocation.Builder builder=wt.request();
		
		//Response resp=builder.get();
		
		//Response resp=builder.post(Entity.text("NONE"));
		
		//Response resp=builder.put(Entity.text("NONE"));
		
		Response resp=builder.delete();
		
		System.out.println(resp.getStatus());
		System.out.println(resp.getStatusInfo());
		System.out.println(resp.readEntity(String.class));
	} catch (Exception e) {
		e.printStackTrace();
	}

	}

}
