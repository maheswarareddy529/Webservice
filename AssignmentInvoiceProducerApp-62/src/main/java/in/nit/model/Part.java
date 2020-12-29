package in.nit.model;

import lombok.Data;

@Data
//Input
public class Part {

	private Integer pid;
	private String pcode;
	private Double pcost;
	private Integer qty;
	private Double discPer;
}
