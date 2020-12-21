package in.nit.controller;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;

@Path("/product")
public class DefaultValueProducer {
	//@MatrixParam(;)
	@GET
	@Path("/invoice")
	public String getBillDetails(
			@MatrixParam("pid")int pid,
			@MatrixParam("pcode")String pcode,
			@MatrixParam("pcost")double amt,
			   @DefaultValue("3") @MatrixParam("discount")int discount
			) {
		
		double discountAmt=amt*discount/100.0;
		double finalAmt=amt-discountAmt;
		return new StringBuffer()
				.append("For Product: ").append(pcode)
				.append(" , Having Id: ").append(pid)
				.append(" , Actual Amount: ").append(amt)
				.append(" , Discount Amount: ").append(discountAmt)
				.append(" , Final Cost Is: ").append(finalAmt)
				.toString();
	}
}
