package in.nit.model;

import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
@Data
@XmlRootElement
public class Student {
private int sid;
private String sname;
private String sfees;
}
