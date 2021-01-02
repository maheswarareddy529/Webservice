package in.nit.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
@Data
@XmlRootElement
//Input
public class Student {
private Integer sid;
private String sname;
private List<Mark> markList;//HAS-A
}
