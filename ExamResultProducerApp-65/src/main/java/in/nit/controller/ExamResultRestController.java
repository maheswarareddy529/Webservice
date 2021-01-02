
package in.nit.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import in.nit.model.Mark;
import in.nit.model.MarksInfo;
import in.nit.model.Result;
import in.nit.model.Student;
@Path("/exam")
public class ExamResultRestController {
	@POST
	@Consumes({"application/xml,application/json"})
	@Produces({"application/xml,application/json"})
	
	public Result findExamResultInfo(
			Student student
			) {
		
		Double totalMarks=0.0;
		Double labTotalMarks=0.0;
		String examInfo="";
		Double allMarks=0.0;
		Double avg=0.0;
		List<MarksInfo> marks=null;
		String grade=null;
		MarksInfo marksInfoList=null;
		
		//total Theory Marks
		List<Mark> marksInfo=student.getMarkList();
		//looping
		Iterator<Mark> itr=marksInfo.iterator();
		while(itr.hasNext()) {
			Mark add=itr.next();
			totalMarks+=add.getTheoryMarks();
		}
		
		//total Lab Marks.....looping
		Iterator<Mark> itr1=marksInfo.iterator();
		while(itr1.hasNext()) {
			Mark add=itr1.next();
			labTotalMarks+=add.getLabmarks();
		}
		
			//Calculate Percentage
		double marksPercentage=totalMarks/marksInfo.size()/100;
		double labMarksPercentage=labTotalMarks/marksInfo.size()/100;
		marks=new ArrayList<>();
		
		//checking pass or failed
		for(Mark m:marksInfo) {
			if(m.getTheoryMarks()>40 && m.getLabmarks()>60) {
				examInfo="PASS";

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
				//Convert to MarksInfo Object
			 marksInfoList=new MarksInfo(m.getSubName(),totalMarks,labTotalMarks,marksPercentage,labMarksPercentage, examInfo);
			}
			else {
				examInfo="FAILED";
				//Convert to MarksInfo Object
			 marksInfoList=new MarksInfo(m.getSubName(),totalMarks,labTotalMarks,marksPercentage,labMarksPercentage, examInfo);
			 grade="---NA----";
			 marks.clear();
			 break;
			}
		//calculating 
				allMarks=totalMarks+labTotalMarks;
				avg=allMarks/m.getSubName().length();
				marks.add(marksInfoList);
		}
		//Result set to Object
		Result re=new Result();
		re.setSid(student.getSid());
		re.setSName(student.getSname());
		re.setTotalMarks(totalMarks);
		re.setAvg(avg);
		re.setMarksInfoList(marks);
		re.setGrade("Grade is: "+grade);
		re.setFinalResult("Final Result is: "+examInfo);
		return re;
		
	}
}
	

