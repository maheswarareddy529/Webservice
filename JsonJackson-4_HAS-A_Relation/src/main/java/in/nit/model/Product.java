package in.nit.model;

import lombok.Data;

@Data
public class Product {
	private int pId;
	private String pNmae;
	private Model mob;//HAS-A
}
