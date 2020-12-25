package in.nit.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
private String hNo;
private String loc;
private String city;
//class as DataType->creating one variable.
private Country ctn;//HAS-A Relation.
}
