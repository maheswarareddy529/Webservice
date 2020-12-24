package in.nit.model;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class Student {
private int sId;
private String sName;
private double sfees;
}
