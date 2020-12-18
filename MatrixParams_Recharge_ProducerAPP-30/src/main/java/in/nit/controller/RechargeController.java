package in.nit.controller;
import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
@Path("/rech")
public class RechargeController {
	//.../rech;serviceId=1301265;billAmt=65.00;custId=2;gst=1.4

	@GET
	public String calculateBill(
			@MatrixParam("serviceId")Long serviceId,
			@MatrixParam("billAmt")double billAmt,
			@MatrixParam("custId")int custId
			) {
		
		int discountVal=new Random().nextInt(9);
		
	     double disAmt=  billAmt*discountVal/100.0;
	     
	     double finalAmt=billAmt-disAmt;
		
		StringBuffer sb=new StringBuffer();
			
		sb.append(" Hello : ").append(custId)//String+String=>append
		.append(" , Thank you for :  ").append(serviceId)
		.append(" , Acutal Bill Is  : ").append(billAmt)
		.append("  ,  Congrats!! discount provided  : ").append(disAmt)
		.append(" ,  Final Pay Amount Is : ").append(finalAmt);

		String message=sb.toString();

		return message;
	}
}
