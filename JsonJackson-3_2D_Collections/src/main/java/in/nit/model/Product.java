package in.nit.model;

import java.util.Map;
import java.util.Properties;

import lombok.Data;
@Data
public class Product {

	private int pId;
	private String pCode;
	private Map<String,String> models;
	private Properties info;
}
