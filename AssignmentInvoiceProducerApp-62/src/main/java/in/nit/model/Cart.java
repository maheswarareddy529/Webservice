package in.nit.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
@Data
@XmlRootElement
//Input
public class Cart {
private Integer cid;
private String code;
private List<Part> parts;
}
