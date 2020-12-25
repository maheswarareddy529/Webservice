package in.nit.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	//@XmlTransient
	@JsonIgnore
	private int sId;
	private String sName;
	//one class has DataType -> Creating variable 
	private Address addr;//HAS-A Relation
	@XmlElementWrapper(name = "courses")
	@XmlElement(name = "course")
	private List<Course> cos;//HAS-A Relation
}
