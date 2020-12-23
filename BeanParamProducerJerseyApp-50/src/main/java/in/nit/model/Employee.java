package in.nit.model;

import javax.ws.rs.QueryParam;

import lombok.Data;

@Data
public class Employee {
     @QueryParam("eid")
	private int empId;
	@QueryParam("ename")
	private String empName;
	@QueryParam("esal")
	private double empSal;
}
