package in.nit.consumer;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import in.nit.model.Student;

public class StudentRestConsumer {

	private static final String URL = "http://localhost:3031/Jersey2AdvJdbcStudentProducerOracle-90";

	
	public static String saveStudent(Student s) {
		String path="/rest/students";
		String respMsg=null;
		try {
			Client c=ClientBuilder.newClient();
			WebTarget wt=c.target(URL).path(path);
			
			Invocation.Builder builder=wt.request();
			Response resp=builder.post(Entity.json(s));//convert to JSON and post 
			
			int status=resp.getStatus();
			System.out.println(status);
			respMsg=resp.readEntity(String.class);
			System.out.println(respMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respMsg;
	}
	
	
	public static List<Student> getAllStudents(){
		String path="/rest/students";
		List<Student> list=null;	
		try {
			Client c=ClientBuilder.newClient();
			WebTarget wt=c.target(URL).path(path);
			Invocation.Builder builder=wt.request();
			
			Response resp=builder.get();
			
			//JSON [{},{},{}] => List<Student>
			list=resp.readEntity(new GenericType<List<Student>>(){});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	} 
	
	public static String deleteStudent(int id) {
		String msg=null;
		String path="/rest/students/"+id;
		try {
			Client c=ClientBuilder.newClient();
			WebTarget wt=c.target(URL).path(path);
			Invocation.Builder builder=wt.request();
			
			Response resp=builder.delete();
			System.out.println(resp.getStatus());
			msg=resp.readEntity(String.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	public static Student getOneStudent(int id) {
		Student std=null;
		String path="/rest/students/"+id;
		try {
			Client c=ClientBuilder.newClient();
			WebTarget wt=c.target(URL).path(path);
			Invocation.Builder builder=wt.request();
			
			Response resp=builder.get();
			std=resp.readEntity(Student.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return std;	
	}
	
	public static String updateStudent(Student s) {
		String path="/rest/students";
		String msg=null;
		try {
			Client c=ClientBuilder.newClient();
			WebTarget wt=c.target(URL).path(path);
			Invocation.Builder builder=wt.request();
			
			Response resp=builder.put(Entity.json(s));//convert obj to JSON
			msg=resp.readEntity(String.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
}







