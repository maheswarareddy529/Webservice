
package in.nit.controller;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import in.nit.model.Cart;
import in.nit.model.Invoice;
import in.nit.model.Part;
import in.nit.model.SaleInfo;
@Path("/bill")
public class BillingProcessRestController {
@Path("/call")
@POST
@Consumes({"application/xml,application/json"})
@Produces({"application/xml,application/json"})
public Invoice calculateInvoiceData(
		Cart cart
		) {
	//Get All Parts Of Data From Cart.
	List<Part> parts=cart.getParts();
	Double totalprice=0.0;
	List<SaleInfo> sales=new ArrayList<>();
	for(Part p: parts) {
		//Calculate Line Values:
		Double lineAmt=p.getPcost()*p.getQty();
		Double discount=lineAmt*p.getDiscPer()/100.0;
		Double lineValue=lineAmt-discount;
		
		//Convert to salesInfo Object.
		SaleInfo sale=new SaleInfo(p.getPcode(),p.getPcost(), lineAmt, discount, lineValue);
		//save in List<SaleInfo>
		sales.add(sale);
		totalprice+=lineValue;
	}
	
	//Calculate GST
	Double gst=totalprice*12/100.0;
	Double billingAmount=totalprice+gst;
	
	//Final Output:Invoice Object.
	Invoice inv=new Invoice();
	inv.setCid(cart.getCid());
	inv.setCode(cart.getCode());
	inv.setSales(sales);
	inv.setTotalPrice(totalprice);
	inv.setGst(gst);
	inv.setBillingAmount(billingAmount);
	return inv;
}
}
