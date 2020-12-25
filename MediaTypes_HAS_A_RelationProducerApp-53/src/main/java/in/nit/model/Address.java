package in.nit.model;

import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
@Data
@XmlRootElement
public class Address {
private String hNo;
private String loc;
private String city;
}
