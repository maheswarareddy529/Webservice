package in.nit.test;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.nit.model.Student;

public class ObjectToJSONTest {

	public static void main(String[] args) {
		try {
			Student st=new Student();
			st.setStdId(101);
			st.setStdName("Sankar");
			st.setStdFees(23443.00F);
			
			/*
			 * //jdk1.7 List<Integer> list=new ArrayList<>();
			 * list.add(89);list.add(87);list.add(82);list.add(85);list.add(69);
			 * st.setMarks(list);
			 */
			/*
			 * //jdk1.2 
			 * Arrays List<Integer> list=Arrays.asList(34,56,78,90,66);
			 * st.setMarks(list);
			 */
			
			//jdk9 Factory Collections ,Immutable Collections
			List<Integer> list=List.of(34,56,78,90,66);
			st.setMarks(list);
			
			  //jdk1.7 
			Set<String> set=new HashSet<>();
			set.add("m1"); set.add("m2"); set.add("m3"); set.add("m4"); set.add("m5"); 
			  st.setSubjects(set);
			 
			
			//jdk1.7
			String g[]=new String[5];
			g[0]="A"; g[1]="B"; g[2]="C"; g[3]="D"; g[4]="E"; 
			st.setGrades(g);
			
			ObjectMapper ob=new ObjectMapper();
			String json=ob.writeValueAsString(st);
			System.out.println(json);
		} catch (Exception e) {
			
		}

	}

}
