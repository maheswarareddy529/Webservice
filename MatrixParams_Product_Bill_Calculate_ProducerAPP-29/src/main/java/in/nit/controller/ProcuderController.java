package in.nit.controller;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
@Path("/prod")
public class ProcuderController {
	//.../prod;pcode=1301A;pcost=65.00;discount=2;gst=1.4;vname=Sankar

	@GET
	public String calculateBill(
			@MatrixParam("pcode")String pcode,
			@MatrixParam("pcost")double pcost,
			@MatrixParam("discount")int discount,
			@MatrixParam("gst")int gst,
			@MatrixParam("vname")String vname
			) {
		double disAmt=pcost*discount/100.0;

		double gstAmt=pcost*gst/100.0;

		double finalAmt=pcost+gstAmt-disAmt;

		StringBuffer sb=new StringBuffer();

		sb.append(" Product : ").append(pcode)//String+String=>append
		.append(" ,Final Amount is :  ").append(finalAmt)
		.append(" , Given By Vendor : ").append(vname)
		.append(" ,  with discount Amount  : ").append(disAmt)
		.append(", And GST Amount  : ").append(gstAmt);

		String message=sb.toString();

		return message;
	}
}
