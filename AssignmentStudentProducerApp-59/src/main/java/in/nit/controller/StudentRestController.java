package in.nit.controller;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import in.nit.model.Student;
@Path("/std")
public class StudentRestController {
@Path("/result")
@POST
@Consumes("application/xml,application/json")
public String printResult(Student student) {
	int total=0;
	double avg=0.0;
	String result="PASS";
	String grade=null;
	int count=0;
	
	List<String> facultyList=student.getFaculties();
	if(facultyList!=null) {
		count=facultyList.size();
	}
	Map<String,Integer> marksMap=student.getMarks();
	Collection<Integer> values=marksMap.values();
	Iterator<Integer> itr=values.iterator();
	while(itr.hasNext()) {
		int v=itr.next();
		total+=v;
		if(v<40) {
			result="FAILD";
		}
		avg=total/3.0f;
		
		if(result.equals("PASS")) {
			if(avg>=75.0) {
				grade="A+";
			}
			else if(avg>=60.0 && avg<=75.0) {
				grade="A";
			}
			else if(avg>=45.0 && avg<=60.0) {
			grade="B+";
			}
			else if(avg>40.0 && avg<=45.0) {
				grade="B";
			}
		}
		else {
			grade="---NA----";
		}
	}
	
	StringBuffer sb=new StringBuffer();
	sb.append(" ID= ").append(student.getSid())
	.append(" , NAME= ").append(student.getSname())
	.append(" , Total Marks= ").append(total)
	.append(" , Average= ").append(avg)
	.append(" , Result= ").append(result)
	.append(" , Grade= ").append(grade)
	.append(" , No Faculties= ").append(count);
	
	return sb.toString();
}
}
