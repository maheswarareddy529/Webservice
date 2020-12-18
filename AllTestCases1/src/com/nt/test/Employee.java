package com.nt.test; 
class Student{
}
public class Employee extends Student {
	public static void main(String[] args) {
		
		//Type comparison operator is instanceof
		Employee e=new Employee();
		System.out.println(e instanceof Student);//true
		
		//If we apply the instanceof operator with any variable that has null value,it return false.
		 Student s=null;
		System.out.println(s instanceof Employee);//false

		//When subclass type refers to the Object of parent class , it it also called as downcasting.
		//If we perform it direclty , compiler gives compilation error.
		//Employee e1=new Student();
		
		//If You perform it by TypeCasting, then ClassCastException thrown at runtime 
		//Employee e2=(Employee)new Student();
		//System.out.println(e2);
		
		//but if we use instanceof operator, downcasting is possible
		Student s1=(Student)e;//copy employee object to student..
		if(s1 instanceof Employee) {
			Employee e2=(Employee)s1;
			System.out.println("DownCasting Done");
		}
	}

}
