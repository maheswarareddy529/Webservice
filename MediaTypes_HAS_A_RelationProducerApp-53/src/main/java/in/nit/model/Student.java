package in.nit.model;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@XmlRootElement
@AllArgsConstructor
@NoArgsConstructor
public class Student {
private int sId;
private String sName;
//one class has DataType -> Creating variable 
private Address addr;//HAS-A Relation
}
