package in.nit.test;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class ConsumerTestAssignmentStudent {

	public static void main(String[] args) {
		String uri="http://localhost:3031/MatrixParams_Student_ProducerAPP-28";
		String path="/rest/std/cal";
	try {
		
		//1. Create Client Object
		Client c=ClientBuilder.newClient();
		
		//2. Add target and path
		WebTarget wt=c.target(uri).path(path);
		
		//3. Add parameters Here to Request
		//MatrixParam(key,value)
		wt=wt.matrixParam("sid","101");
		wt=wt.matrixParam("sname","Sname");
		wt=wt.matrixParam("eng",98);
		wt=wt.matrixParam("mat",96);
		wt=wt.matrixParam("sci",94);
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
