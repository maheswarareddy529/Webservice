package in.nit.test;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class ConsumerTest {
	public static void main(String[] args) {
	try {
		String url="http://localhost:3031/ProducerJersey2_32-31";
		String path="/rest/prod/s";

		Client c=ClientBuilder.newClient();
		WebTarget wt=c.target(url).path(path);
		Invocation.Builder builder=wt.request();

		Response resp=builder.get();
		System.out.println(resp.getStatus());
		System.out.println(resp.getStatusInfo());
		System.out.println(resp.readEntity(String.class));
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
}

