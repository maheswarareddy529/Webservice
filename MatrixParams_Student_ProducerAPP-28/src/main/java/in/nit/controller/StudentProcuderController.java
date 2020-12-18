package in.nit.controller;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
@Path("/std")
public class StudentProcuderController {
	//.../std/cal;sid=101;sname=Sankar;eng=93;math=94;sci=91
	
	@Path("/cal")
	@GET
	public String calculateResult(
			          @MatrixParam("sid")int sid,
			          @MatrixParam("sname")String sname,
			          @MatrixParam("eng")int eng,
			          @MatrixParam("mat")int mat,
			          @MatrixParam("sci")int sci
			) {
		
		int total=eng+mat+sci;
		double avg=total/3.0;
		String grade=null;
		if(avg>=85) {
			grade="A+";
		}
		else if(avg<85 && avg>=60) {
			grade="A";
		}
		else if(avg<60 && avg>=45) {
			grade="B";
		}
		else if(avg>45 && avg>35) {
			grade="C";
		}
		else {
			grade="Un Defined";
		}
		StringBuffer sb=new StringBuffer();
		
		sb.append("Hello: ").append(sname)//String+String=>append
		.append(" , With ID:  ").append(sid)
		.append(" , Total Marks: ").append(total)
		.append(" , Average is : ").append(avg)
		.append(", Grade is : ").append(grade);
		
		String message=sb.toString();
		
		return message;
	}
	
	@Path("/data")
	@GET
	public String getData(
			@MatrixParam("sid")int sid,
			@MatrixParam("sname")String sname
			) {
		return "Data is=>:  "+sid+" , "+sname;
	}
}
