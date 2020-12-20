package in.nit.controller;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/payment")
public class FormParamPaymentProducer {

	@Path("/card")
	@POST    //if using form must take POST
	public String doPayment(
			@FormParam("cardNum")String cardNumber,
			@FormParam("cardName")String cardHolderName,
			@FormParam("expMonth")String expMonth,
			@FormParam("expYear")int expYear,
			@FormParam("cvv")String cvv,
			@FormParam("amt")double amt
			) {
		
		StringBuffer sb=new StringBuffer();
		
		String message=sb
			     .append("Hello Mr/Mrs/Ms :  ").append(cardHolderName)
				.append(" , Amount : ").append(amt)
				.append(" , is paid from your Card : ").append(cardNumber)
				.append(" , Having Details : CVV=").append(cvv)
				.append(" , Date : ").append(expMonth).append("/").append(expYear)
				.toString();
				
		
		return message;
	}
}
