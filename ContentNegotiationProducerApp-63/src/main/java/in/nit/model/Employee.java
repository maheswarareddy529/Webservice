package in.nit.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@XmlRootElement
@NoArgsConstructor
public class Employee {
private int empId;
private String empName;
private double empSal;
@JsonIgnore
private String secrete;
}
