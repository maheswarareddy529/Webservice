package in.nit.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;

public class ConsumerJerseyConsumerTest {

	public static void main(String[] args) {
		String url="http://localhost:3031/FormParamJersey2ProducerApp-36";
		String path="/rest/payment/card";
		try {
			//Creating Form class Object
			Form f=new Form();
			
			//Adding DATA to Form Object
			f.param("cardNum","12334");
			f.param("cardName","Sankar");
			f.param("expMonth","JAN");
			f.param("cardYear","2023");
			f.param("cvv","123");
			f.param("amt","123.445");
			
			Client c=ClientBuilder.newClient();
			WebTarget wt=c.target(url).path(path);
			
			Invocation.Builder builder=wt.request();
			
			//Sending Data Using Request Body(Entity.form(form(Obj))
			Response resp=builder.post(Entity.form(f));
			
			System.out.println(resp.getStatus());
			System.out.println(resp.getStatusInfo());
			System.out.println(resp.readEntity(String.class));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
