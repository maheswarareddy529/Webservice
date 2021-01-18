package in.nit.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
private Integer stdId;
private String stdName;
private String stdCource;
private Double stdFee;
private Double stdDiscount;
}
