package in.nit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	private Integer stdId;
	private String stdName;
	private String stdCourse;
	private Double stdFee;
	private Double stdDiscount;
	
}
/**
create table students (
  sid int,sname varchar(25), 
  scourse varchar(15),
  sfee double, sdiscount double);
**/

