package in.nit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//Output
public class MarksInfo {
private String subName;
private Double  thoeryMarks;
private Double labMarks;
private Double theoryMarksPer;
private Double labMarksPer;
private String examInfo;
}
