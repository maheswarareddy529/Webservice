package in.nit.model;

import lombok.Data;

@Data
public class Employee  {
	private int eId;
	private String eNmae;
	private Address eAdd;//HAS-A
}
