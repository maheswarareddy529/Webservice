package com.nt.test;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

//class+JAXB Annotations ==>JAXB Class
@XmlRootElement//<employee>......</employee>
//Enable JAXB Annotations which are defined on FIELDs(variables)
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Student {
   
	private Integer stdId;
	private String stdCode;
	@XmlElementWrapper(name ="all-subjects" )
     @XmlElement(name="subj")
	private List<String>  subject;
    
}
