package in.nit.model;

import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.QueryParam;

import lombok.Data;

@Data
public class Employee {
     @QueryParam("eid")
	private int empId;
	@HeaderParam("ename")
	private String empName;
	@FormParam("esal")
	private double empSal;
}
