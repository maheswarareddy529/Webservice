package in.nit.model;
 
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class Employee {
private Integer empId;
private String empName;
private Address add;//HAS_A
private List<String> projects;
private Map<String,String> varsions;

}
