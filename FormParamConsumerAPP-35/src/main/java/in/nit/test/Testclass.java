package in.nit.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;

public class Testclass {
	public static void main(String[] args) {
		String URI="http://localhost:3031/FormParamProducerAPP-35";
		String path="/rest/payment/user";
		try {
			//Creating Form Class object
			Form f=new Form();
			//adding dats to Form object
			f.param("u", "ABC-123");
			
			Client c=ClientBuilder.newClient();
			WebTarget wt=c.target(URI).path(path);
			
			Invocation.Builder builder=wt.request();
			//sending data using Request Body (Entity.form(formObj))
			Response resp=builder.post(Entity.form(f));
			
			System.out.println(resp.getStatus());
			System.out.println(resp.getStatusInfo());
			System.out.println(resp.readEntity(String.class));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
