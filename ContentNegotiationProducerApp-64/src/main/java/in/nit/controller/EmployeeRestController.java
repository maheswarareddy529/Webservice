
package in.nit.controller;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import in.nit.model.Employee;
@Path("/emp")
public class EmployeeRestController {
@POST
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public String showData(Employee e) {
	return "My Data is:"
	+e.getEmpId()+" , "
	+e.getEmpName()+" , "
	+e.getEmpSal()+" , "
	+e.getSecrete();
}
}

