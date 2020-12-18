package com.nt.test;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

//class+JAXB Annotations ==>JAXB Class
@XmlRootElement//<employee>......</employee>
@Data
public class Employee {

	private Integer empId;
	private String empName;
	private Double empSal;
	private String empDept;
	
}
