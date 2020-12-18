package in.nit.model;

import lombok.Data;

@Data
public class Product  {
	private int pid;
	private String pcode;
	private double pcost;
	//note Default Constructor,setter,getter toString must override 
}
