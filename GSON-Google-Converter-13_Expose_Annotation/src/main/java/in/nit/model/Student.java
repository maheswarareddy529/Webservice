package in.nit.model;
 
import com.google.gson.annotations.Expose;

import lombok.Data;

@Data
public class Student {
	//Note primitive types are not recomended  take fields as wrapper types.
	
	@Expose //meaning please use this property in JSON.
	private Integer stdId;
	
	@Expose//meaning please use this property in JSON.
	private String stdName;
	private Double stdFee;
	private String stdCource;
	private String secureCode;
}
