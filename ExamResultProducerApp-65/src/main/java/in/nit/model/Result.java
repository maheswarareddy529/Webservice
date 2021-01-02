package in.nit.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
@Data
@XmlRootElement
//Output
public class Result {
private Integer sid;
private String sName;
private Double totalMarks;
private Double avg;
private String grade;
private List<MarksInfo> marksInfoList;
private String finalResult;
}
