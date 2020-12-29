package in.nit.model;
import java.util.List;
import java.util.Map;

import lombok.Data;
@Data
public class Customer {
	private Integer custid;
	private String custname;
	private Map<String,Integer> items;
	private Map<String,Integer> card;;
	private List<Integer> discount;
}
