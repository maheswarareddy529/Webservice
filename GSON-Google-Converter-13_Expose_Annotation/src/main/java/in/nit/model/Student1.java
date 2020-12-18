package in.nit.model;

import com.google.gson.annotations.Expose;

import lombok.Data;
 
@Data
public class Student1 {
	//Note primitive types are not recomended  take fields as wrapper types.
	
	@Expose //meaning please use this property in JSON.
	private Integer stdId;
	
	@Expose(serialize = true,//take stdName from  Obj->show in JSON
			deserialize = false)//Do not take stdName from JSON into Obj
	private String stdName;
	
	@Expose(serialize =false,//Data in Object (not taken into JSON)
			deserialize = true)//Data in JSON->Taken in object
	private Double stdFee;
	
	@Expose(deserialize = true)//default added as serialize=true
	//@Expose(serialize = false)//default added as deserialize=true
	private String stdCource;
}
