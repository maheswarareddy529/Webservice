package in.nit.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
@Data
@XmlRootElement
//Output
public class Invoice {
private Integer cid;
private String code;
private List<SaleInfo> sales;
private Double totalPrice;
private Double gst;
private Double billingAmount;
}
