package in.nit.model;

import javax.ws.rs.QueryParam;

import lombok.Data;

@Data
public class Employee {
     @QueryParam("id")
	private int empId;
	@QueryParam("name")
	private String empName;
}