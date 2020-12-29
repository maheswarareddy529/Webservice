/*
 * package in.nit.controller;
 * 
 * import java.util.Collection; import java.util.Iterator; import
 * java.util.List; import java.util.Map;
 * 
 * import javax.ws.rs.Consumes; import javax.ws.rs.POST; import
 * javax.ws.rs.Path;
 * 
 * import in.nit.model.Student;
 * 
 * @Path("/std") public class StudentRestController {
 * 
 * @Path("/result")
 * 
 * @POST
 * 
 * @Consumes("application/xml,application/json") public String
 * printResult(Student student) { int total=0; double avg=0.0; String
 * result="PASS"; String grade=null; int count=0;
 * 
 * List<String> facultyList=student.getFaculties(); if(facultyList!=null) {
 * count=facultyList.size(); } Map<String,Integer> marksMap=student.getMarks();
 * Collection<Integer> values=marksMap.values(); Iterator<Integer>
 * itr=values.iterator(); while(itr.hasNext()) { int v=itr.next(); total+=v;
 * if(v<40) { result="FAILD"; } avg=total/3.0f;
 * 
 * if(result.equals("PASS")) { if(avg>=75.0) { grade="A+"; } else if(avg>=60.0
 * && avg<=75.0) { grade="A"; } else if(avg>=45.0 && avg<=60.0) { grade="B+"; }
 * else if(avg>40.0 && avg<=45.0) { grade="B"; } } else { grade="---NA----"; } }
 * 
 * StringBuffer sb=new StringBuffer();
 * sb.append(" ID= ").append(student.getSid())
 * .append(" , NAME= ").append(student.getSname())
 * .append(" , Total Marks= ").append(total) .append(" , Average= ").append(avg)
 * .append(" , Result= ").append(result) .append(" , Grade= ").append(grade)
 * .append(" , No Faculties= ").append(count);
 * 
 * return sb.toString(); } }
 */

package in.nit.controller;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import in.nit.model.Customer;
@Path("/cust")
public class CustomerRestController {
@Path("/bill")
@POST
@Consumes("application/xml,application/json")
public String calBill(Customer customer) {
	double totalCost=0;
	double gst=0;
	double totalBill=0;
	double totalQt=0;
	double pamt=0;
	String sb=null;
	Map<String,Integer> items=customer.getItems();
	Collection<Integer> prices=items.values();
	Iterator<Integer> itr=prices.iterator();
	
	Map<String,Integer> card=customer.getCard();
	Collection<Integer> qt=card.values();
	Iterator<Integer> itr1=qt.iterator();
	
	List<Integer> discount=customer.getDiscount(); 
	Iterator<Integer> itr2=discount.iterator();
	
	while(itr.hasNext()) {
	while(itr1.hasNext()) {
	while(itr2.hasNext()) {
		double dsAmt=itr2.next();
		
		totalCost=itr.next();
		
		totalQt=itr1.next();
	
		pamt=totalCost*totalQt;
		dsAmt=pamt*dsAmt/100;
		double amt=pamt-dsAmt;
		totalCost=amt;
		gst=totalCost*dsAmt/100.0;
		totalBill=totalCost+gst;
		
		Random r=new Random();
		Integer random=r.nextInt(1234567890);
		customer.setCustid(random);
		 sb= new StringBuffer()
				 .append(" Customer id: ").append(customer.getCustid())
				 .append(" Customer Name: ").append(customer.getCustname())
			.append(" All Above Details+ ").append(" Items")
			.append(items).append(",")
			.append(" TotalCost( After Discount = ").append(totalCost)
			.append(" Gst= ").append(gst)
			.append(" TotalBill= ").append(totalBill)
			.toString();
		 System.out.println(sb);
	}
	}
	}
	return sb;
}
}
