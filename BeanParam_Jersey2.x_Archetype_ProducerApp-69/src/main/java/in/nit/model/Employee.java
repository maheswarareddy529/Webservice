package in.nit.model;

import javax.ws.rs.QueryParam;

import lombok.Data;
@Data
public class Employee {

	private @QueryParam("eid")Integer eid;
	private @QueryParam("ename")String ename;
	private @QueryParam("esal")Double esal;
}
