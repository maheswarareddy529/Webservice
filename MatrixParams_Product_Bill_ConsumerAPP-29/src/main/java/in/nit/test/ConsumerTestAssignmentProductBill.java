package in.nit.test;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class ConsumerTestAssignmentProductBill {

	public static void main(String[] args) {
		String uri="http://localhost:3031/MatrixParams_Product_Bill_Calculate_ProducerAPP-29";
		String path="/rest/prod";
	try {
		
		//1. Create Client Object
		Client c=ClientBuilder.newClient();
		
		//2. Add target and path
		WebTarget wt=c.target(uri).path(path);
		
		//3. Add parameters Here to Request
		//MatrixParam(key,value)
		wt=wt.matrixParam("pcode","1011A");
		wt=wt.matrixParam("pcost",23.43);
		wt=wt.matrixParam("discount",4);
		wt=wt.matrixParam("gst",3);
		wt=wt.matrixParam("vname","Sankar");
		//4. Convert to Request
		Invocation.Builder builder=wt.request();
		
		//5.Provide method type
		Response resp=builder.get();
		
		//6.Print Entity and Status
		System.out.println(resp.getStatus());
		System.out.println(resp.getStatusInfo());
		System.out.println(resp.readEntity(String.class));
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
}
