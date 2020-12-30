
package in.nit.controller;


import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import in.nit.model.Employee;
@Path("/emp")
public class EmployeeRestController {
@POST
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public Employee showData() {
	Employee e=new Employee();
	e.setEmpId(678);
	e.setEmpName("Sankar");
	e.setEmpSal(66.88);
	e.setSecrete("8uhhu7");
	return e;
}
}

