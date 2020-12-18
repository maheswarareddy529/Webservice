package in.nit.test;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.nit.model.Student;

public class TestSaveFile {

	public static void main(String[] args) {
		try {
			
				Student s=new Student();
				s.setSId(101);
				s.setSNmae("Sankar");
				s.setSCourse("JAVA");
				s.setSFees(3422.00f);
				
			ObjectMapper om=new ObjectMapper();
			File f=new File("s.json");
			om.writeValue(f,s);
			System.out.println("Done");
			
		} catch (Exception e) {
		}

	}

}



