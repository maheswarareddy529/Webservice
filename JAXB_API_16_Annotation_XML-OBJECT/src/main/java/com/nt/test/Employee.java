package com.nt.test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import lombok.Data;

//class+JAXB Annotations ==>JAXB Class
@XmlRootElement//<employee>......</employee>
//Enable JAXB Annotations which are defined on FIELDs(variables)
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Employee {
     @XmlAttribute(name = "employee-id")
	private Integer empId;
     @XmlElement(name="employee-name")
	private String empName;
     @XmlElement(name="employee-salary")
	private Double empSal;
     @XmlElement(name="employee-project")
     private String empProjects;
     @XmlElement(name="employee-experience")
     private Double empExp;
     //Ignore any variable
     @XmlTransient
	private String empDept;
	
}
