package com.nt.test; 
import java.util.Map;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@XmlRootElement
@Data
public class Company {
   
	private Integer cId;
	private Map<String,String> projects;
}
